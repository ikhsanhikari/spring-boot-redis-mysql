package id.hikari.hikari.test.core.impl;


import id.hikari.hikari.test.core.BaseEndPoint;
import id.hikari.hikari.test.data.dto.response.JsonWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
public class BaseEndPointImpl<T,ID> implements BaseEndPoint<T,ID> {
    @Autowired
    CrudRepository<T,ID> baseRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseEndPointImpl.class);

    Class<T> persistentClass;
    String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BaseEndPointImpl() {
        this.persistentClass = (Class<T>)
                ((ParameterizedType)getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0];
        this.path=this.persistentClass.getSimpleName().toLowerCase();
    }


    @Override
    @PostMapping("")
    public ResponseEntity save(@RequestBody T t){
        baseRepository.save(t);
        return  ResponseEntity.ok(new JsonWrapper(0,"save",HttpStatus.OK,null));

    }

    @Override
    @GetMapping("")
    public ResponseEntity findAll() {
//        List<T> result = Lists.newArrayList(baseRepository.findAll());
//        int size = result.size();
        return ResponseEntity.ok(new JsonWrapper(0,"readAll data "+this.path,HttpStatus.OK,baseRepository.findAll()));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") ID id) {
        T t = baseRepository.findById(id).orElse(null);
        List<T> ts = new ArrayList<>();
        if(t!=null){
            ts.add(t);
        }else{
            LOGGER.error("Can't find Id {} ",id);
            return ResponseEntity.ok(new JsonWrapper(ts.size(),"Read By Id", HttpStatus.NOT_FOUND,ts));
        }
        return ResponseEntity.ok(new JsonWrapper(ts.size(),"Read By Id", HttpStatus.OK,ts));
    }



    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") ID id){
        T t = baseRepository.findById(id).get();
        baseRepository.delete(t);
        return ResponseEntity.ok(new JsonWrapper(0,"delete",HttpStatus.OK,null));
    }
}
