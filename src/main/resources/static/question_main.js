    // Make a request for a user with a given ID
    function selectAllQuestion(){
        axios.get('http://localhost:8089/questions')
      .then(function (response) {
        // handle success
        console.log(response);
        questionData(response);
      })
      .catch(function (error) {
        // handle error
        console.log(error);
      })
      .finally(function () {
        // always executed
      });
    }


     function questionData(response){
        var question = document.getElementById('question');
        var questionList = response.data.attributes;
        var result = '<table class="table">'+
                        '<tr>'+
                            '<th>No</th>'+
                            '<th>Question</th>'+
                            '<th>Answer</th>'+
                        '</tr>';
        for (var a = 0 ; a < questionList.length; a++){
            var responseQuestion = questionList[a];
            var answerList = response.data.attributes[a].answers;
            result += '<tr>'+
                            '<td rowspan="'+(answerList.length+1)+'">'+responseQuestion.id+'</td>'+
                            '<td rowspan="'+(answerList.length+1)+'">'+responseQuestion.question+'</td>'+
                        '</tr>';

            for (var b = 0; b < answerList.length; b++){
                var responseAnswer = answerList[b];
                if(responseAnswer.status==true){
                    result += '<tr>'+
                            '<td><b>'+responseAnswer.variable+'. '+responseAnswer.answer+'</b> </td>'+
                        '</tr>';
                }else{
                    result += '<tr>'+
                            '<td>'+responseAnswer.variable+'. '+responseAnswer.answer+' </td>'+
                        '</tr>';
                }

            }
        }
        result+='</table>';
        question.innerHTML = result;
      }

      function save(){
        var frm = document.forms['frm'];
        var payload = {
            question: frm['questionText'].value,
            questionType: frm['questionType'].value,
            questionLevel:frm['questionLevel'].value,
            answers: [
                {
                    status: frm['status[0]'].checked,
                    answer: frm['answer[0]'].value
                },
                {
                    status: frm['status[1]'].checked,
                    answer: frm['answer[1]'].value
                },
                {
                    status: frm['status[2]'].checked,
                    answer: frm['answer[2]'].value
                },
                {
                    status: frm['status[3]'].checked,
                    answer: frm['answer[3]'].value
                }
            ]
          };
        axios.post('http://localhost:8089/questions', payload)
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