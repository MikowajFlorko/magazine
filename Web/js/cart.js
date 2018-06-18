var cart = {};

$.ajax({
    'url': 'http://localhost:8080/goods/allGoods',
    'type': "GET",
    'contentType': 'application/json',
    'success': function (data) {
        var goods = data;
        console.log(goods);
        checkCart();
        console.log(cart);
        showCart();
        
        function showCart(){
            if($.isEmptyObject(cart)){
                var out = 'Корзина пуста. Додайте товар в корзину <a href = "index.html">Замовити</a>';
                $('#my-cart').html(out);
            }
            else{
            
            var out = '';
            for (var key in cart){
                out += '<button class="delete" data-id="'+key+'">X</button>';
                out += '<img id="cartImage" src="'+goods[key].image+'">';
                out +=  goods[key].marka;
                out +=  goods[key].model;
                out += '<button class="minus" data-id="'+key+'">-</button>';
                out +=  cart[key];
                out += '<button class="plus" data-id="'+key+'">+</button>';
                out +=  cart[key]*goods[key].price;
                out += '<br>';

            }
            $('#my-cart').html(out);
            $('.plus').on('click', plusGoods);
            $('.minus').on('click', minusGoods);
            $('.delete').on('click', deleteGoods);
        }
        }
        function plusGoods(){
            var articul = $(this).attr('data-id');
            cart[articul]++;
            saveCartToLS();
            showCart();
        }
        function minusGoods(){
            var articul = $(this).attr('data-id');
            if(cart[articul] >1) {
                cart[articul]--;
            }
            else {
                delete cart[articul];
            }
            saveCartToLS();
            showCart();
        } 
        function deleteGoods(){
            var articul = $(this).attr('data-id');
            delete cart[articul];
            saveCartToLS();
            showCart();
        } 
   }
}); 

 function checkCart(){
        if(localStorage.getItem('cart') != null){
            cart = JSON.parse(localStorage.getItem('cart'));
        }
    }
function saveCartToLS(){
localStorage.setItem('cart', JSON.stringify(cart)); 
}

function isEmpty(object){
for(var key in object)
    if (object.hasOwnProperty(key)) return true;
    return false;
}

function sendEmail(){
    var name = $('#name').val();
    var surname = $('#surname').val();
    var email = $('#email').val();
    var phone = $('#phone').val();
    var phone1 = phone.replace(/\D+/g,"").substr(2,11);
    var out = '';
        for(var w in cart){
            out += w
        }
    var quantity = '';
        for(var w in cart){
            quantity += cart[w]
        }        
   
    if( name!='' && surname!='' && email!='' && phone!=''){
        if(isEmpty(cart)){
            var newGoods = {
            "name": name,
            "surname":surname,
            "email":email,
            "phone":phone1,
            "goodsId": out,
            "quantity": quantity
            }
            $.ajax({
                'url': 'http://localhost:8080/orders',
                'type': "PUT",
                'contentType': 'application/json',
                'dataType': 'json',
                'data': JSON.stringify(newGoods),
                'success': function(data) {
                  console.log(data);
                  alert('Ви успішно замовили товар');
                  location.href ="index.html";
                }
            });
         }else{
             alert('Корзина пуста');
         }        
        
    }else {
        alert('Заповніть всі поля');
}
}

$(document).ready(function(){
    $('.send-email').on('click', sendEmail);
})
$(function() {
    function maskPhone() {
      var country = $('#country option:selected').val();
      switch (country) {
        case "ua":
          $("#phone").inputmask("+380(99) 999-99-99");
          break;
      }    
    }
    maskPhone();
    $('#country').change(function() {
      maskPhone();
    });
  });