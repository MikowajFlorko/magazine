function getGoods() {
    $.ajax({
        'url': 'http://localhost:8080/admin/allGoods',
        'type': "GET",
        'contentType': 'application/json',
        'success': function (data) {
            console.log(data);
            var out = '<select>';
            out += '<option data-id="0">' + "Новий товар" + '</option>';
            for (var id in data) {

                out += '<option data-id ="' + data[id].id + '">' + data[id].name + '</option>';
            }
            out += '</select>';
            $('.goods-out').html(out);
            $('.goods-out select').on('change', selectGoods);
        }
    });
}


function selectGoods() {
    
    var id = $('.goods-out select option:selected').attr('data-id');
    console.log(id);
    var findOne = {
        "id": id
    }
    $.ajax({
        'url': 'http://localhost:8080/admin/findOne',
        'type': "POST",
        'contentType': 'application/json',
        'dataType': 'json',
        'data': JSON.stringify(findOne),
        'success': function (data) {
            $('#name').val(data.name);
            $('#cost').val(data.price);
            $('#id').val(data.id);  
        }

    });
}
function saveToDb() {
    var id = $('#id').val();
    console.log(id);
    if (id != undefined) {
        var findOne = {
            "id": id,
            "name": $('#name').val(),
            "price": $('#cost').val()
        }
        $.ajax({
            'url': 'http://localhost:8080/admin/updateGoods',
            'type': "POST",
            'contentType': 'application/json',
            'dataType': 'json',
            'data': JSON.stringify(findOne),
            'success': function (data) {
             alert('товар змінено');
            }
        })
    }
}
$('#cGoods').click(function (){
    var newGoods = {
            "name": $('#addNameGoods').val(),
            "price": $('#addCostGoods').val()      
        }
        $.ajax({
            'url': 'http://localhost:8080/admin/createGoods',
            'type': "PUT",
            'contentType': 'application/json',
            'dataType': 'json',
            'data': JSON.stringify(newGoods),
            'success': function (data) {
                console.log(newGoods);
             alert('товар додано');
            }
        });
    });

$(document).ready(function () {
    $('.add-to-db').on('click', saveToDb);
    getGoods();
});

function a() {
    document.getElementsByClassName("navi")[0].classList.toggle("icon");
}
$(function () {
    $('a[href="#addGoods"]').on('click', function(event) {
        event.preventDefault();
        $('#addGoods').addClass('open');
        $('#addGoods > form > input[type="goods"]').focus();
    });
    
    $('#addGoods, #addGoods button.close').on('click keyup', function(event) {
        if (event.target == this || event.target.className == 'close' || event.keyCode == 27) {
            $(this).removeClass('open');
        }
    });     
    
});
