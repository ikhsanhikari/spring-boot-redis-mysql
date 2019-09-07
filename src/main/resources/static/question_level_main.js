    // Make a request for a user with a given ID
    function selectAllQuestionLevel(){
        axios.get('http://localhost:8089/question_levels')
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
        var questionLevel = document.getElementById('question_level');
        var questionLevelList = response.data.data;
        var result = '<table  class="table">'+
                        '<tr>'+
                            '<th>No</th>'+
                            '<th>Question Level</th>'+
                            '<th>Action</th>'+
                        '</tr>';
        for (var a = 0 ; a < questionLevelList.length; a++){

            result += '<tr>'+
                            '<td>'+questionLevelList[a].id+'</td>'+
                            '<td>'+questionLevelList[a].questionLevel+'</td>'+
                            '<td><button class="btn btn-danger" onclick="deleteQuestionLevel('+questionLevelList[a].id+')"><span class="fa fa-trash" ></span> </button> '+
                            '<button class="btn btn-info" onclick="getQuestionLevel('+questionLevelList[a].id+')"><span class="fa fa-undo" data-toggle="modal" data-target="#myModal" ></span></button></td>'+
                        '</tr>';
        }
        result+='</table>';
        questionLevel.innerHTML = result;
      }

      function save(){
        var frm = document.forms['frm'];
        var payload = {
            questionLevel: frm['questionLevel'].value
          };
        axios.post('http://localhost:8089/question_levels', payload)
          .then(function (response) {
            console.log(response);
            Swal.fire(
              'Success',
              'Question Level has been saving',
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
              questionLevel: frm['questionLevel'].value

            };
          axios.post('http://localhost:8089/question_levels', payload)
            .then(function (response) {
              selectAllQuestionLevel();
              Swal.fire(
                'Success',
                'Question Level has been saving',
                'success'
              )

              //window.location.href = "http://localhost:8089/question";
            })
            .catch(function (error) {
              console.log(error);
            });
        }


      function deleteQuestionLevel(params){
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
                    'http://localhost:8089/question_levels/'+params
                  ).then(function(){
                      Swal.fire(
                          'Deleted!',
                          'Your file has been deleted.',
                          'success'
                        )
                    selectAllQuestionLevel();
                  }).catch(function(error){
                    console.log(error);
                  });

            }
          })
      }

      function getQuestionLevel(params){
        axios.get('http://localhost:8089/question_levels/'+params)
              .then(function (response) {
                // handle success
                var modal_question_type = document.getElementById('modal_question_level');
                var responseQusetionLevel = response.data.data;

                document.getElementById('id').value = responseQusetionLevel.id;
                modal_question_type.innerHTML = '<div class="col-md-6">'+
                                                     '<div class="form-group">'+
                                                         '<label for="questionLevel">Question Level:</label>'+
                                                         '<input type="text" class="form-control" id="questionLevel" value="'+responseQusetionLevel.questionLevel+'" name="questionLevel">'+
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
