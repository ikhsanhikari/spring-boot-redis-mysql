    // Make a request for a user with a given ID
    function selectAllAnswer(){
        axios.get('http://localhost:8089/answers')
          .then(function (response) {
            // handle success
            answerData(response);
          })
          .catch(function (error) {
            // handle error
            console.log(error);
          })
          .finally(function () {
            // always executed
          });
    }


     function answerData(response){
        var answer = document.getElementById('answer');
        var answerList = response.data.data;
        var result = '<table  class="table">'+
                        '<tr>'+
                            '<th>No</th>'+
                            '<th>Answer</th>'+
                            '<th>Question</th>'+
                            '<th>Variable</th>'+
                            '<th>Status</th>'+
                            '<th >Action</th>'+
                        '</tr>';
        for (var a = 0 ; a < answerList.length; a++){

            result += '<tr>'+
                            '<td>'+answerList[a].id+'</td>'+
                            '<td>'+answerList[a].answer+'</td>'+
                            '<td>'+answerList[a].idQuestion+'</td>'+
                            '<td>'+answerList[a].variable+'</td>'+
                            '<td>'+answerList[a].status+'</td>'+
                            '<td><button class="btn btn-danger" onclick="deleteAnswer('+answerList[a].id+')"><span class="fa fa-trash" ></span> </button> '+
                            '<button class="btn btn-info" onclick="getAnswer('+answerList[a].id+')"><span class="fa fa-undo" data-toggle="modal" data-target="#myModal" ></span></button></td>'+
                        '</tr>';
        }
        result+='</table>';
        answer.innerHTML = result;
      }

      function save(){
        var frm = document.forms['frm'];
        var payload = {
            variable: frm['variable'].value,
            answer: frm['answerText'].value,
            status:frm['status'].checked,
            idQuestion: frm['idQuestion'].value

          };
        axios.post('http://localhost:8089/answers', payload)
          .then(function (response) {
            console.log(response);
            Swal.fire(
              'Success',
              'Answer has been saving',
              'success'
            )
            //selectAllQuestion();
            //window.location.href = "http://localhost:8089/question";
          })
          .catch(function (error) {
            console.log(error);
          });
      }
      function update(){
          var frm = document.forms['frm'];
          var payload = {
              id: frm['id'].value,
              variable: frm['variable'].value,
              answer: frm['answerText'].value,
              status:frm['status'].checked,
              idQuestion: frm['idQuestion'].value

            };
          axios.post('http://localhost:8089/answers', payload)
            .then(function (response) {
              selectAllAnswer();
              Swal.fire(
                'Success',
                'Answer has been saving',
                'success'
              )

              //window.location.href = "http://localhost:8089/question";
            })
            .catch(function (error) {
              console.log(error);
            });
        }
      function createAnswerForm(){
           var result = '';
           for (var a=0;a<4;a++){
                result+= '<div class="form-group">'+
                        '<label for="answer['+a+']">Answer '+(a+1)+' </label>'+
                        '<div class="input-group mb-3">'+
                            '<div class="input-group-prepend">'+
                                '<div class="input-group-text">'+
                                    '<input type="checkbox" name="status['+a+']" id="status['+a+']">'+
                                '</div>'+
                            '</div>'+
                            '<input type="text" class="form-control"  name="answer['+a+']" id="answer['+a+']">'+
                        '</div>'+
                    '</div>';
           }
           document.getElementById('answerForm').innerHTML = result;
      }

      function deleteAnswer(params){
          Swal.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
          }).then((result) => {
            if (result.value) {
                axios.delete(
                    'http://localhost:8089/answers/'+params
                  ).then(function(){
                      Swal.fire(
                          'Deleted!',
                          'Your file has been deleted.',
                          'success'
                        )
                    selectAllAnswer();
                  }).catch(function(error){
                    console.log(error);
                  });

            }
          })
      }

      function getAnswer(params){
        axios.get('http://localhost:8089/answers/'+params)
              .then(function (response) {
                // handle success
                var modal_answer = document.getElementById('modal-answer');
                var responseAnswer = response.data.data;
                var isCheck = "";
                if(responseAnswer.status){
                    isCheck = "checked";
                }
                selectLovQuestion(responseAnswer.idQuestion);
                document.getElementById('id').value = responseAnswer.id;
                modal_answer.innerHTML = '<div class="form-group">'+
                                              '<label for="answerText">Answer:</label>'+
                                              '<textarea class="form-control" rows="5" id="answerText" name="answerText">'+responseAnswer.answer+'</textarea>'+
                                          '</div>'+
                                          '<div class="form-group">'+
                                              '<label for="variable">Variable:</label>'+
                                              '<select class="form-control" id="variable"  value = "'+responseAnswer.variable+'" name="variable">'+
                                                  '<option value="A">A</option>'+
                                                  '<option value="B">B</option>'+
                                                  '<option value="C">C</option>'+
                                                  '<option value="D">D</option>'+
                                              '</select>'+
                                          '</div>'+
                                          '<div class="form-group">'+
                                              '<label for="idQuestion">Id Question:</label>'+
                                              '<select class="form-control" id="idQuestion"  name="idQuestion">'+
                                                  '<option>1</option>'+
                                                  '<option>2</option>'+
                                                  '<option>3</option>'+
                                                  '<option>4</option>'+
                                              '</select>'+
                                          '</div>'+
                                          '<div class="form-group">'+
                                              '<input type="checkbox" id="status" '+isCheck+' name="status"> <label>Status</label>'+
                                          '</div>';
//                answerData(response);
                    idQ = responseAnswer.idQuestion;
                    document.getElementById('variable').value=responseAnswer.variable;
                    console.log('id Q: '+idQ);
//                    if(){
//
//                    }
              })
              .catch(function (error) {
                // handle error
                console.log(error);
              })
              .finally(function () {
                // always executed
              });
      }

    function selectLovQuestion(params){
        axios.get('http://localhost:8089/question-masters/lov')
          .then(function (response) {
            // handle success
            var listLov = response.data;
            var result = '<option value="0">Choose</option>';
            for (var a=0;a<listLov.length;a++){
                if(listLov[a].id==params){
                    result+='<option value="'+listLov[a].id+'" selected>('+listLov[a].id+'). '+listLov[a].name+'</option>'
                }else{
                    result+='<option value="'+listLov[a].id+'">('+listLov[a].id+'). '+listLov[a].name+'</option>'
                }
            }
            document.getElementById('idQuestion').innerHTML = result;

          })
          .catch(function (error) {
            // handle error
            console.log(error);
          })
          .finally(function () {
            // always executed
          });
     }
