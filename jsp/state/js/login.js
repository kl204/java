

function subInfoDisplay(){

    var con = document.getElementById('subInfo');

    if(con.style.display == 'none'){
        con.style.display = 'block';
    }else{
        con.style.display = 'none';
    }

}

function findAddress() {
    console.log("findaddress in first");

    new daum.Postcode({
        
        oncomplete: function (data) {
            var addr = '';

            console.log("findaddress in");

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
                console.log(addr);
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                 addr = data.jibunAddress;
                 console.log(addr);

            }

            document.getElementById('address').value = addr;
        }
    }).open();
}
