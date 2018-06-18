$('document').ready(function () {
    allGoods();
    findGoodsByCategory();   
});
function allGoods(){
     $.ajax({
            'url': 'http://localhost:8080/admin/allGoods',
            'type': "GET",
            'contentType': 'application/json',
           'headers': {
                       Token: localStorage.getItem('token')
                   },
            'success': function (data) {
                var id = '';
                var markaGoods = '';
                var modelGoods = '';
                var category = '';
                var price = '';
                var Delete = '';
                    for (var key in data) {
                        id += '<ol>' + data[key].id + '</ol>';
                        markaGoods += '<ol>' + data[key].marka + '</ol>';
                        modelGoods += '<ol>' + data[key].model + '</ol>';
                        category += '<ol>' + data[key].category + '</ol>';
                        price += '<ol>' + data[key].price + '</ol>';
                        Delete += '<font size="-1"><ol><button class="delete" value="' + data[key].id + '">Delete</button></ol></font>';
                    }
                $('#id').html(id);
                $('#markaGoods').html(markaGoods);
                $('#modelGoods').html(modelGoods);
                $('#category').html(category);
                $('#price').html(price);
                $('#Delete').html(Delete);
                
                    setClickOnDelete();
                    

                }
            });
}
function findGoodsByCategory(){
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
            $('.categoryAdminGoods').html(category);
            }
      })
 $('.categoryAdminGoods').click(function () {
       
        var id = $('.categoryAdminGoods select option:selected').attr('data-id');
        if (id != 0) {
        var category = {
            'id': id
        }

        $.ajax({
            'url': 'http://localhost:8080/admin/findGoodsByCategory',
            'type': "POST",
            'contentType': 'application/json',
              'headers': {
                       Token: localStorage.getItem('token')
                   },
            'dataType': 'json',
            'data': JSON.stringify(category),
            'success': function (data) {
                var id = '';
                var markaGoods = '';
                var modelGoods = '';
                var category = '';
                var price = '';
                var Delete = '';
                    for (var key in data) {
                        id += '<ol>' + data[key].id + '</ol>';
                        markaGoods += '<ol>' + data[key].marka + '</ol>';
                        modelGoods += '<ol>' + data[key].model + '</ol>';
                        category += '<ol>' + data[key].category + '</ol>';
                        price += '<ol>' + data[key].price + '</ol>';
                        Delete += '<font size="-1"><ol><button class="delete" value="' + data[key].id + '">Delete</button></ol></font>';
                    }
                $('#id').html(id);
                $('#markaGoods').html(markaGoods);
                $('#modelGoods').html(modelGoods);
                $('#category').html(category);
                $('#price').html(price);
                $('#Delete').html(Delete);
                
                    setClickOnDelete();
                    

                }
            });
        }else{
            allGoods();
        }
 })
}

       function setClickOnDelete() {
            $('.delete').click(function() {
                var deleteReq = {
                    'id': this.value
                }
                $.ajax({
                    'url': 'http://localhost:8080/admin/deleteGoods',
                    'type': "DELETE",
                    'contentType': 'application/json',
                      'headers': {
                      Token: localStorage.getItem('token'),
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