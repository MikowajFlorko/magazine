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
            $('.category').html(category);
            }
      })
    
}

$('.category').click(function () {
    
    var id = $('.category select option:selected').attr('data-id');
    if (id != 0) {
    var category = {
            'id': id
        }    
$.ajax({
        'url': 'http://localhost:8080/admin/findMarkaByCategory',
        'type': "POST",
            'contentType': 'application/json',
    'headers': {
                       Token: localStorage.getItem('token')
                   },         
    'dataType': 'json',
            'data': JSON.stringify(category),
            'success': function (data) {
            console.log(data);
            var marka = '<select>';
            marka += '<option data-id="0">' + "---Категорія---" + '</option>';
            for (var id in data) {
            marka += '<option data-id ="' + data[id].id + '">' + data[id].name + '</option>';
            }
            marka += '</select>';
            $('.marka').html(marka);
            }
      })}else{
            category += '<option data-id="0">' + "---Категорія---" + '</option>';
        }
  })
     
            $('#addGoods').click(function() {
            var model = $('#modelGoods').val();
            var price = $('#price').val();
            var idCategory = $('.category select option:selected').attr('data-id');
            var marka = $('.marka select option:selected').attr('data-id');
            var file = document.getElementById('file').files[0];
            console.log(file);
            var reader = new FileReader();
            reader.readAsDataURL(file);
                reader.onload = function(){
                 var base64picture = reader.result;   
                
                                  
            var newGoods = {
                'marka': marka,
                'model': model,
                'price': price,
                'categoryId':idCategory,        
                'imageName': base64picture
            }
        $.ajax({
                'url': 'http://localhost:8080/admin/createGoods',
                'type': "PUT",
                'contentType': 'application/json',
            'headers': {
                       Token: localStorage.getItem('token')
                   },
                   'dataType': 'json',
                'data': JSON.stringify(newGoods),
                'success': function(data) {
                    alert('Товар додано');
                    location.href = 'adminCreateGoods.html'
                }
            })
                }
        });

                     
$('#btnExit').click(function () {
    localStorage.clear();
})