    // Make a request for a user with a given ID
    function selectAllQuestionMaster(){
        axios.get('http://localhost:8089/question-masters')
          .then(function (response) {
            // handle success
            QuestionMasterData(response);
          })
          .catch(function (error) {
            // handle error
            console.log(error);
          })
          .finally(function () {
            // always executed
          });
    }


     function QuestionMasterData(response){
        var questionMaster = document.getElementById('question-master');
        var questionMasterList = response.data.data;
        var result = '<table class="table">'+
                        '<tr>'+
                            '<th>No</th>'+
                            '<th>Question</th>'+
                            '<th>Question Type</th>'+
                            '<th>Question Level</th>'+
                            '<th colspan="2">Action</th>'+
                        '</tr>';
        for (var a = 0 ; a < questionMasterList.length; a++){

            result += '<tr>'+
                            '<td>'+questionMasterList[a].id+'</td>'+
                            '<td>'+questionMasterList[a].question+'</td>'+
                            '<td>'+questionMasterList[a].questionType+'</td>'+
                            '<td>'+questionMasterList[a].questionLevel+'</td>'+
                            '<td><button class="btn btn-danger" onclick="deleteQuestionMaster('+questionMasterList[a].id+')"><span class="fa fa-trash" ></span> </button> '+
                            '<button class="btn btn-info" onclick="getQuestionMaster('+questionMasterList[a].id+')"><span class="fa fa-undo" data-toggle="modal" data-target="#myModal" ></span></button></td>'+
                        '</tr>';
        }
        result+='</table>';
        questionMaster.innerHTML = result;
      }

      function save(){
        var frm = document.forms['frm'];
        var payload = {
            question: frm['questionText'].value,
            questionLevel: frm['questionLevel'].value,
            questionType:frm['questionType'].value,

          };
        axios.post('http://localhost:8089/question-masters', payload)
          .then(function (response) {
            console.log(response);
            Swal.fire(
              'Success',
              'Question has been saving',
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
              question: frm['questionText'].value,
              questionLevel: frm['questionLevel'].value,
              questionType:frm['questionType'].value,

            };
          axios.post('http://localhost:8089/question-masters', payload)
            .then(function (response) {
              selectAllQuestionMaster();
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


      function deleteQuestionMaster(params){
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
                    'http://localhost:8089/question-masters/'+params
                  ).then(function(){
                      Swal.fire(
                          'Deleted!',
                          'Your file has been deleted.',
                          'success'
                        )
                    selectAllQuestionMaster();
                  }).catch(function(error){
                    console.log(error);
                  });

            }
          })
      }

      function getQuestionMaster(params){
        axios.get('http://localhost:8089/question-masters/'+params)
              .then(function (response) {
                // handle success
                console.log(response);
                var modalQuestionMaster = document.getElementById('modal-question-answer');
                var responseQuestionMaster = response.data.data;
                selectLovQuestionType(responseQuestionMaster.questionType);
                selectLovQuestionLevel(responseQuestionMaster.questionLevel);
                document.getElementById('id').value = responseQuestionMaster.id;
                modalQuestionMaster.innerHTML = '<div class="col-md-12">'+
                                                     '<div class="form-group">'+
                                                         '<label for="questionText">Question:</label>'+
                                                         '<textarea class="form-control" rows="5" id="questionText" name="questionText">'+responseQuestionMaster.question+'</textarea>'+
                                                     '</div>'+
                                                     '<div class="form-group">'+
                                                         '<label for="questionType">Question Type:</label>'+
                                                         '<select class="form-control" id="questionType" name="questionType">'+
                                                             '<option>1</option>'+
                                                             '<option>2</option>'+
                                                             '<option>3</option>'+
                                                             '<option>4</option>'+
                                                         '</select>'+
                                                     '</div>'+
                                                     '<div class="form-group">'+
                                                         '<label for="questionLevel">Question Level:</label>'+
                                                         '<select class="form-control" id="questionLevel" name="questionLevel">'+
                                                             '<option>1</option>'+
                                                             '<option>2</option>'+
                                                             '<option>3</option>'+
                                                             '<option>4</option>'+
                                                         '</select>'+
                                                     '</div>'+
                                             '</div>';
                document.getElementById('questionLevel').value = responseQuestionMaster.questionLevel;
                document.getElementById('questionType').value = responseQuestionMaster.questionType;

              })
              .catch(function (error) {
                // handle error
                console.log(error);
              })
              .finally(function () {
                // always executed
              });
      }

    function selectLovQuestionType(params){
        axios.get('http://localhost:8089/question_types/lov')
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
            document.getElementById('questionType').innerHTML = result;

          })
          .catch(function (error) {
            // handle error
            console.log(error);
          })
          .finally(function () {
            // always executed
          });
     }
     function selectLovQuestionLevel(params){
         axios.get('http://localhost:8089/question_levels/lov')
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
             document.getElementById('questionLevel').innerHTML = result;
           })
           .catch(function (error) {
             // handle error
             console.log(error);
           })
           .finally(function () {
             // always executed
           });
      }
