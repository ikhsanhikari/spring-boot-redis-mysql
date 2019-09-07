    // Make a request for a user with a given ID
    function selectAllQuestionType(){
        axios.get('http://localhost:8089/question_types')
          .then(function (response) {
            // handle success
            questionTypeData(response);
          })
          .catch(function (error) {
            // handle error
            console.log(error);
          })
          .finally(function () {
            // always executed
          });
    }


     function questionTypeData(response){
        var questionType = document.getElementById('question_type');
        var questionTypeList = response.data.data;
        var result = '<table  class="table">'+
                        '<tr>'+
                            '<th>No</th>'+
                            '<th>Question Type</th>'+
                            '<th colspan="2">Action</th>'+
                        '</tr>';
        for (var a = 0 ; a < questionTypeList.length; a++){

            result += '<tr>'+
                            '<td>'+questionTypeList[a].id+'</td>'+
                            '<td>'+questionTypeList[a].questionType+'</td>'+
                            '<td><button class="btn btn-danger" onclick="deleteQuestionType('+questionTypeList[a].id+')"><span class="fa fa-trash" ></span> </button> '+
                            '<button class="btn btn-info" onclick="getQuestionType('+questionTypeList[a].id+')"><span class="fa fa-undo" data-toggle="modal" data-target="#myModal" ></span></button></td>'+
                        '</tr>';
        }
        result+='</table>';
        questionType.innerHTML = result;
      }

      function save(){
        var frm = document.forms['frm'];
        var payload = {
            questionType: frm['questionType'].value
          };
        axios.post('http://localhost:8089/question_types', payload)
          .then(function (response) {
            console.log(response);
            Swal.fire(
              'Success',
              'Question Type has been saving',
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
              id : frm['id'].value,
              questionType: frm['questionType'].value

            };
          axios.post('http://localhost:8089/question_types', payload)
            .then(function (response) {
              selectAllQuestionType();
              Swal.fire(
                'Success',
                'Question Types has been saving',
                'success'
              )

              //window.location.href = "http://localhost:8089/question";
            })
            .catch(function (error) {
              console.log(error);
            });
        }


      function deleteQuestionType(params){
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
                    'http://localhost:8089/question_types/'+params
                  ).then(function(){
                      Swal.fire(
                          'Deleted!',
                          'Your file has been deleted.',
                          'success'
                        )
                    selectAllQuestionType();
                  }).catch(function(error){
                    console.log(error);
                  });

            }
          })
      }

      function getQuestionType(params){
        axios.get('http://localhost:8089/question_types/'+params)
              .then(function (response) {
                // handle success
                var modal_question_type = document.getElementById('modal_question_type');
                var responseQusetionType = response.data.data;

                document.getElementById('id').value = responseQusetionType.id;
                modal_question_type.innerHTML = '<div class="col-md-6">'+
                                                     '<div class="form-group">'+
                                                         '<label for="questionType">Question Type:</label>'+
                                                         '<input type="text" class="form-control" id="questionType" value="'+responseQusetionType.questionType+'" name="questionType">'+
                                                     '</div>'+
                                                 '</div>';
              })
              .catch(function (error) {
                // handle error
                console.log(error);
              })
              .finally(function () {
                // always executed
              });
      }
