    // Make a request for a user with a given ID
    function selectAllShortAnswer(){
        axios.get('http://localhost:8089/short_answers')
          .then(function (response) {
            // handle success
            questionLevelData(response);
          })
          .catch(function (error) {
            // handle error
            console.log(error);
          })
          .finally(function () {
            // always executed
          });
    }


     function questionLevelData(response){
        var shortAnswer = document.getElementById('short_answer');
        var shortAnswerList = response.data.data;
        var result = '<table  class="table">'+
                        '<tr>'+
                            '<th>No</th>'+
                            '<th>Question</th>'+
                            '<th>Short Answer</th>'+
                            '<th>Question Level</th>'+
                            '<th>Action</th>'+
                        '</tr>';
        for (var a = 0 ; a < shortAnswerList.length; a++){

            result += '<tr>'+
                            '<td>'+shortAnswerList[a].id+'</td>'+
                            '<td>'+shortAnswerList[a].question+'</td>'+
                            '<td>'+shortAnswerList[a].shortAnswer+'</td>'+
                            '<td>'+shortAnswerList[a].questionLevel+'</td>'+
                            '<td><button class="btn btn-danger" onclick="deleteShortAnswer('+shortAnswerList[a].id+')"><span class="fa fa-trash" ></span> </button> '+
                            '<button class="btn btn-info" onclick="getShortAnswer('+shortAnswerList[a].id+')"><span class="fa fa-undo" data-toggle="modal" data-target="#myModal" ></span></button></td>'+
                        '</tr>';
        }
        result+='</table>';
        shortAnswer.innerHTML = result;
      }

      function save(){
        var frm = document.forms['frm'];
        var payload = {
            shortAnswer: frm['shortAnswer'].value,
            question: frm['questionText'].value,
            questionLevel: frm['questionLevel'].value
          };
        axios.post('http://localhost:8089/short_answers', payload)
          .then(function (response) {
            console.log(response);
            Swal.fire(
              'Success',
              'Short Answer has been saving',
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
              shortAnswer: frm['shortAnswer'].value,
              question: frm['questionText'].value,
              questionLevel: frm['questionLevel'].value

            };
          axios.post('http://localhost:8089/short_answers', payload)
            .then(function (response) {
              selectAllShortAnswer();
              Swal.fire(
                'Success',
                'Short Answer has been saving',
                'success'
              )

              //window.location.href = "http://localhost:8089/question";
            })
            .catch(function (error) {
              console.log(error);
            });
        }


      function deleteShortAnswer(params){
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
                    'http://localhost:8089/short_answers/'+params
                  ).then(function(){
                      Swal.fire(
                          'Deleted!',
                          'Your file has been deleted.',
                          'success'
                        )
                    selectAllShortAnswer();
                  }).catch(function(error){
                    console.log(error);
                  });

            }
          })
      }

      function getShortAnswer(params){
        axios.get('http://localhost:8089/short_answers/'+params)
              .then(function (response) {
                // handle success
                var modal_question_type = document.getElementById('modal_short_answer');
                var responseShortAnswer = response.data.data;

                selectLovQuestionLevel(responseShortAnswer.questionLevel);

                document.getElementById('id').value = responseShortAnswer.id;
                modal_short_answer.innerHTML = '<div class="col-md-12">'+
                                                     '<div class="form-group">'+
                                                         '<label for="questionText">Question:</label>'+
                                                         '<textarea class="form-control" rows="5" id="questionText" name="questionText">'+responseShortAnswer.question+'</textarea>'+
                                                     '</div>'+
                                                     '<div class="form-group">'+
                                                         '<label for="shortAnswer">Short Answer:</label>'+
                                                         '<input type="text" class="form-control" id="shortAnswer" value="'+responseShortAnswer.shortAnswer+'" name="shortAnswer">'+
                                                     '</div>'+
                                                     '<div class="form-group">'+
                                                         '<label for="questionLevel">Question Type:</label>'+
                                                         '<select class="form-control" id="questionLevel" name="questionLevel">'+
                                                             '<option>1</option>'+
                                                             '<option>2</option>'+
                                                             '<option>3</option>'+
                                                             '<option>4</option>'+
                                                         '</select>'+
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
