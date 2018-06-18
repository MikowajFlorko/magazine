$('document').ready(function () {
    findAllCategory();
   
});
function findAllCategory(){
    $.ajax({
        'url': 'http://localhost:8080/admin/findAllCategory',
        'type': "GET",
        'contentType': 'application/json',
       'headers': {
                       Token: localStorage.getItem('token')
                   },       
        'success': function (data) {
            console.log(data);
            var category = '<select>';
            category += '<option data-id="0">' + "---Категорія---" + '</option>';
            for (var id in data) {
                category += '<option data-id ="' + data[id].id + '">' + data[id].name + '</option>';
            }
            category += '</select>';
            $('.categoryInMarka').html(category);
        }
        
    })
}  
$('#addMarka').click(function() {
            var category = $('.categoryInMarka select option:selected').attr('data-id');
            var name = $('#marka').val();
                                  
            var newMarka = {
                'name': name,
                'category': category
                };
            $.ajax({
                'url': 'http://localhost:8080/admin/createMarka',
                'type': "PUT",
                'contentType': 'application/json', 
                'headers': {
                       Token: localStorage.getItem('token')
                   },             

                'dataType': 'json',
                'data': JSON.stringify(newMarka),
                'success': function(data) {
                    alert('Товар додано');
                    location.href = 'adminCreateGoods.html'
                }
            });
        });
 $.ajax({
        'url': 'http://localhost:8080/admin/findAllMarka',
        'type': "GET",
        'contentType': 'application/json',
      'headers': {
                       Token: localStorage.getItem('token')
                   },   
     'success': function (data) {
            for (var key in data) {
                var id = $('#id');
                var name = $('#name');
                var category = $('#category')
                var deleteCategory = $('#delete');
                id.append('<ol>' + data[key].id + '</ol>');
                name.append('<ol>' + data[key].name + '</ol>');
                category.append('<ol>' + data[key].category + '</ol>');
                
                deleteCategory.append('<font size="-1"><ol><button class="delete" value="' + data[key].id + '">Delete</button></ol></font>');
           
            }
            setClickOnDelete();
            }
      })
function setClickOnDelete() {
            $('.delete').click(function() {
                var deleteReq = {
                    'id': this.value
                }
                $.ajax({
                    'url': 'http://localhost:8080/admin/deleteMarka',
                    'type': "DELETE",
                    'contentType': 'application/json',
                     'headers': {
                       Token: localStorage.getItem('token')
                   },
                    'dataType': 'json',
                    'data': JSON.stringify(deleteReq),
                    'success': function() {
                        location.reload();
                    }
                });
            });
        }
$('#btnExit').click(function () {
    localStorage.clear();
})
   
   