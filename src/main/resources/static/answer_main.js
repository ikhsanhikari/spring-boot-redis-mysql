    // Make a request for a user with a given ID
    function selectAllAnswer(){
        axios.get('http://localhost:8089/answers')
      .then(function (response) {
        // handle success
        console.log(response);
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
        var result = '<table border = "1" class="table">'+
                        '<tr>'+
                            '<th>No</th>'+
                            '<th>Answer</th>'+
                            '<th>Question</th>'+
                            '<th>Variable</th>'+
                            '<th>Status</th>'+
                            '<th>Action</th>'+
                        '</tr>';
        for (var a = 0 ; a < answerList.length; a++){

            result += '<tr>'+
                            '<td>'+answerList[a].id+'</td>'+
                            '<td>'+answerList[a].answer+'</td>'+
                            '<td>'+answerList[a].idQuestion+'</td>'+
                            '<td>'+answerList[a].variable+'</td>'+
                            '<td>'+answerList[a].status+'</td>'+
                            '<td><span class="fa fa-trash" onclick="deleteAnswer('+answerList[a].id+')"></span></td>'+
                        '</tr>';
        }
        result+='</table>';
        answer.innerHTML = result;
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

