    // Make a request for a user with a given ID
    function selectAllSummary(){
        axios.get('http://localhost:8089/summary_standard/list')
          .then(function (response) {
            // handle success
            summaryData(response);
          })
          .catch(function (error) {
            // handle error
            console.log(error);
          })
          .finally(function () {
            // always executed
          });
    }


     function summaryData(response){
        var summary = document.getElementById('summary');
        var summaryList = response.data.data;
        var p = '';
        var result = '<table  class="table">'+
                        '<tr>'+
                            '<th>Id</th>'+
                            '<th>Username</th>'+
                            '<th>Email</th>'+
                            '<th>Phone</th>'+
                            '<th>Created At</th>'+
                            '<th >Package Unique</th>'+
                            '<th >Action</th>'+
                        '</tr>';
        for (var a = 0 ; a < summaryList.length; a++){
            p = summaryList[a].packageUnique;

            result += '<tr>'+
                            '<td>'+summaryList[a].id+'</td>'+
                            '<td>'+summaryList[a].username+'</td>'+
                            '<td>'+summaryList[a].email+'</td>'+
                            '<td>'+summaryList[a].phone+'</td>'+
                            '<td>'+summaryList[a].createdAt+'</td>'+
                            '<td>'+summaryList[a].packageUnique+'</td>'+
                            '<td><button class="btn btn-info" onclick="result('+summaryList[a].id+',\''+p+'\')"><span class="fa fa-eye" ></span> </button> '+
                        '</tr>';
        }
        result+='</table>';
        summary.innerHTML = result;
      }

      function result(userId,packageUnique){
            window.location = 'http://localhost:8089/standard-exercise-result?idUser='+userId+'&packageUnique='+packageUnique
      }

