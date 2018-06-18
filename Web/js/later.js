function getLater() {
    $.ajax({
        'url': 'http://localhost:8080/goods/allGoods',
        'type': "GET",
        'contentType': 'application/json',
        'success': function (data) {
            console.log(data);
            var out = '';
            var later = {};
            if (localStorage.getItem('later')) {
                later = JSON.parse(localStorage.getItem('later'));
                for (var key in later) {
                console.log(later);
                out += '<div class="single-goods">';
                out += '<button class="later" data-id="' + key + '">' + "&hearts;" + '</button>';
                out += '<img id="image" src="'+data[key]['image']+'">'
                out += '<h3>'+ data[key]['marka'] + '</h3>';
                out += '<h5>'+ data[key]['model'] + '</h5>';
                out += '<p>' + "Ціна:" +" "+ data[key]['price'] +" "+"грн."+'</p>';
                out += '<a href="goods.html#'+key+'">' + "Переглянути" + '</a>';
                out += '</div>'
                    
            }        $('#goods').html(out);
            }else{
                $('#goods').html('Додайте товар:');                
            }
    
        }
    });
}
getLater();