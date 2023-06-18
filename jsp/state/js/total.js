	// ���� ��ü ���� ��� default
	$(document).ready(function(){
	  $.getJSON('../state/dataSec.json', function(data){
		var html= '';

		$(data).each(function(data, obj){
			
			  html += `<tr><td>${obj.book_no}</td><td>${obj.title}</td><td>${obj.memberNo}</td><td>${obj.author}</td><td>${obj.rentDate}</td><td>${obj.rental_check}</td><td>${obj.return_check}</td></tr>`;
		  });

		  $('#tableIn').html(html);
	
	  });

	});

fetch('http://localhost:5501/jsp/state/data.json')
// �⺻ ��ü ���̺� Default
  .then(response => response.json())
  .then(jsonData => {
    // const jsonObj = jsonData;
    // const outputCotentEle = document.getElementById('outputContent');
    // outputCotentEle.innerHTML = getContent(jsonObj);
    // console.log(jsonData);

    // ���� ������ ���� ���̺� ����� 
    const sortTbl = document.getElementById('sortTbl');
    sortTbl.addEventListener('change', () => {
      const jsonObj = jsonData;

      const selectedOption = sortTbl.options[sortTbl.selectedIndex].text;
      if (selectedOption !== '���ļ�') {
        const outputSelectEle = document.getElementById('outputContent');
        outputSelectEle.innerHTML = searchClick(jsonObj);
      }
    });




    // ���� �̸�, ��ȣ ���� �˻�, ���̺� �����
    const searchButton = document.getElementById('searchBookButton');
    searchButton.addEventListener('click', () => {
      const jsonObj = jsonData;

      const outputButtonEle = document.getElementById('outputContent');
      outputButtonEle.innerHTML = findText(jsonObj);
      console.log(outputButtonEle.innerText);

    });

  // ��¥�� ���� ���̺� ����
    const dateSearchButton = document.getElementById('searchDateButton');
    dateSearchButton.addEventListener('click', () => {
      const jsonObj = jsonData;

      const outputButtonEle = document.getElementById('outputContent');
      outputButtonEle.innerHTML = dateSearch(jsonObj);
      console.log(outputButtonEle.innerText);
  
    });
    
     
    return fetch('http://localhost:5501/jsp/state/data.json')
    
  })
// 
//   .then(response => response.json())
//   .then(jsonData_ => {
//     const jsonObj_ = jsonData_;

//     const sortTbl = document.getElementById('sortTbl');
//     sortTbl.addEventListener('change', () => {
//       const selectedOption = sortTbl.options[sortTbl.selectedIndex].text;
//       if (selectedOption !== '���ļ�') {
//         const outputSelectEle = document.getElementById('outputContent');
//         outputSelectEle.innerHTML = searchClick(jsonObj_);
//       }
//     });
//     // console.log(jsonData_);
//     return fetch('http://localhost:5501/jsp/state/data.json')
//   })

  .catch(error => {
    // ���� ó��
    console.error('Error:', error);
  })


const setRow = (obj)=>{
    const{
        book_no,
        title,
        memberNo,
        author,
        rentDate,
        rental_check,
        return_check,
    }= obj;
    const rowtext = `<tr><td>${book_no}</td><td>${title}</td><td>${memberNo}</td><td>${author}</td><td>${rentDate}</td><td>${rental_check}</td><td>${return_check}</td></tr>`;
    return rowtext;
};

// const getcontents =()=>{
//     $(document).ready(function(){

//       $.getJSON('../json/data.json', function(data){

//         $(data).each(function(data, obj){
//               $('outputContent').append(`<tr><td>${book_no}</td><td>${title}</td><td>${memberNo}</td><td>${author}</td><td>${rentDate}</td><td>${rental_check}</td><td>${return_check}</td></tr>`);
//           });

//       })

//     });
//   }

// const getContent=(data)=> {
//     const header = data.header;
//     const content = data.contents;  

//     const outputTotalNumEle = document.getElementById('totalNum');
//     outputTotalNumEle.innerHTML = "<b>��ü</b>"+ "<b>"+content.length+"</b>" + "<b>��</b>";

//     const theadStr = "<thead><th>������ȣ</th><th>������</th><th>ȸ����ȣ</th><th>ȸ����</th><th>������</th><th>����</th><th>�ݳ�</th></thead>";
//     let tbodyStr = "<tbody>";

//     // for(let i =0;i<content.length;i+=5){ 

//       for(let j = 0 ;j < content.length ; j++){

//          var tableRow = {
//               book_no : content[j].book_no,
//               title : content[j].title,
//               memberNo : "00000"+j,
//               author : content[j].author,
//               rentDate : "2023-06-0"+j,
//               rental_check : content[j].rental_check,
//               return_check : '<button class="btn_s_red"> �ݳ� </button>'

//          };

//          tbodyStr += setRow(tableRow);
//        }
//     // }
//     tbodyStr+="</tbody>";

//     // // Pagenation ���
//     // const outputButtonEle = document.getElementById('pagenation');
//     // outputButtonEle.innerHTML = pagenation(content.length, );
    

//     return (theadStr + tbodyStr);

// }

const searchClick=(jsonObj_)=>{

  var num = document.getElementById("sortTbl").selectedIndex;
  var arr = document.getElementById("sortTbl").options;

  let clickSearch = arr[num].text;

  console.log(clickSearch);

  const content = jsonObj_.contents;

  const theadStr = "<thead><th>������ȣ</th><th>������</th><th>ȸ����ȣ</th><th>ȸ����</th><th>������</th><th>����</th><th>�ݳ�</th></thead>";
  let tbodyStr = "<tbody>";

  var nameResult = [];

  var tbodyStrArr = [];

  for(let i =0;i<30;i++){

      var tableRows = {
          book_no : content[i].book_no,
          title : content[i].title,
          memberNo : "00000"+i,
          author : content[i].author,
          rentDate : "2023-07-"+i,  
          rental_check : content[i].rental_check,
          return_check : '<button class="btn_s_red"> �ݳ� </button>'

      };
      tbodyStrArr.push(tableRows);      

    }

  if(clickSearch == "������"){
    console.log("������ in");

    nameResult = tbodyStrArr.sort(function(a,b){
      let x = a.rentDate;
      let y = b.rentDate;

      return new Date(x).getDate() - new Date(y).getDate();

      // if(x<y){
      //   return -1;
      // }
      // if(x>y){
      //   return 1;
      // }
      // return 0;
    });

    const outputTotalNumEle = document.getElementById('totalNum');
    outputTotalNumEle.innerHTML = "<b>��ü</b>"+ nameResult.length + "<b>��</b>";

    console.log(nameResult);
  }

  if(clickSearch == "������"){
    console.log("������ ��");
    nameResult = tbodyStrArr.sort(function(a,b){
      let x = a.title.toLowerCase();
      let y = b.title.toLowerCase();
      if(x<y){
        return -1;
      }
      if(x>y){
        return 1;
      }
      return 0;
    });
    
    const outputTotalNumEle = document.getElementById('totalNum');
    outputTotalNumEle.innerHTML = "<b>��ü</b>"+ nameResult.length + "<b>��</b>";
  }

  if(clickSearch == "ȸ����"){
    console.log("ȸ���� in");

    nameResult = tbodyStrArr.sort(function(a,b){
      let x = a.author.toLowerCase();
      let y = b.author.toLowerCase();
      if(x<y){
        return -1;
      }
      if(x>y){
        return 1;
      }
      return 0;
    });

    const outputTotalNumEle = document.getElementById('totalNum');
    outputTotalNumEle.innerHTML = "<b>��ü</b>"+ nameResult.length + "<b>��</b>";
  }

  for(let j =0;j<nameResult.length;j++){
    tbodyStr += setRow(nameResult[j]);
  }
  console.log(tbodyStr);

  tbodyStr+="</tbody>";
  return (theadStr + tbodyStr);
  

}

const findText=(jsonObjt)=>{

  var nameResult = [];

  var tbodyStrArr = [];

  var num = document.getElementById("selectBook").selectedIndex;
  var arr = document.getElementById("selectBook").options;

  let clickSearch = arr[num].text;

  const content = jsonObjt.contents;

  const theadStr = "<thead><th>������ȣ</th><th>������</th><th>ȸ����ȣ</th><th>ȸ����</th><th>������</th><th>����</th><th>�ݳ�</th></thead>";
  let tbodyStr = "<tbody>";

  console.log(clickSearch);

  const searchBook = document.getElementById('selectBook');
  const selectedOption = searchBook.options[searchBook.selectedIndex].text;
 
  for(let i =0;i<30;i++){

    var tableRows = {
        book_no : content[i].book_no,
        title : content[i].title,
        memberNo : "00000"+i,
        author : content[i].author,
        rentDate : "2023-07-0"+i,
        rental_check : content[i].rental_check,
        return_check : '<button class="btn_s_red"> �ݳ� </button>'

    };
    tbodyStrArr.push(tableRows);      

  }
 
  const name = document.getElementById('searchBook').value;

//  ���ڿ� Ȯ��
  if(typeof tbodyStrArr[0].book_no === 'string'){
    console.log("true");
  }

 
  if (selectedOption !== '��ü') {

   if(clickSearch == "������ȣ"){
     console.log("������ȣ in");

      for(let j =0; j < tbodyStrArr.length;j++){
      if(tbodyStrArr[j].book_no == name){



          // console.log(typeof tbodyStrArr[0].book_no);


       console.log("book_no ã��");
       nameResult.push(tbodyStrArr[j]);
        } 
      }

      const outputTotalNumEle = document.getElementById('totalNum');
      outputTotalNumEle.innerHTML = "<b>��ü</b>"+ nameResult.length + "<b>��</b>";

    }

   if(clickSearch == "������"){
     console.log("������ ��");

      for(let j =0; j < tbodyStrArr.length;j++){
        if(tbodyStrArr[j].title == name){
          console.log("title ã��");
          nameResult.push(tbodyStrArr[j]);
          } 
        }

        const outputTotalNumEle = document.getElementById('totalNum');
        outputTotalNumEle.innerHTML = "<b>��ü</b>"+ nameResult.length + "<b>��</b>";
    }
  }else{
    for(let j =0; j < tbodyStrArr.length;j++){
      // tbodyStrArr[j].book_no �� name�� Ÿ���̱� ������ ���ڿ� ��ȯ �� indexOf �ؾ��Ѵ�.
      let bookNo = tbodyStrArr[j].book_no;
      let bookNo_ = bookNo.toString();

      let titleName = tbodyStrArr[j].title;
      let titleName_ = titleName.toString();

      if(bookNo_.indexOf(name) != -1){
       console.log("å��ȣ�� ã��");
       nameResult.push(tbodyStrArr[j]);
        } 

      if(titleName_.indexOf(name) != -1){
          console.log("å�̸����� ã��");
          nameResult.push(tbodyStrArr[j]);
        } 
      }

      const outputTotalNumEle = document.getElementById('totalNum');
      outputTotalNumEle.innerHTML = "<b>��ü</b>"+ nameResult.length + "<b>��</b>";
  }



  for(let k =0;k<nameResult.length;k++){
    tbodyStr += setRow(nameResult[k]);
  }

  console.log(tbodyStr);
  
  tbodyStr+="</tbody>";
  return (theadStr + tbodyStr);
  
}

// const pagenation=(totalCnt, curentPg)=>{

//   // �� ������ ����
//   const totalCount = totalCnt;
//   // �� �������� ������ ����(���)
//   const pageCount = 5;

//   // �� ������ ���
//   let totalPage =Math.ceil(totalCount/pageCount);

//   //���� ������
//   const curentPage = curentPg;

//   //���� ��� ������ �׷����� (ex/ ù��° �׷�= ��ư1,2,3,4,5 �ټ��� / �ι�° �׷� = ��ư 6,7,8,9,10 �ټ���)
//   let pageGroup = Math.ceil(curentPage / pageCount);

//   let lastNumber = pageGroup * pageCount;
//   if(lastNumber > totalPage){
//     lastNumber = totalPage;
//   }
//   let firstNumber = lastNumber - (pageCount - 1);

//   const next = lastNumber + 1;
//   const prev = firstNumber - 1;

//   let buttonStr;
//   //�� ó�� �׷쿡�� ���� ��ư ���� 
//   if(prev == 0){

//     for(let i = firstNumber ; i <lastNumber; i++){
//       buttonStr += `<button class="pageNumber" type = "button" id="page_${i}" onclick="pagenation(``${totalCount}``,page_``${i})"> ${i} </button>`
//     }
  
//   //�ι�° �׷� ���ʹ� ù��° �׷����� ���ư� �� �ֱ� ������ ���� ��ư�� ����
//   }else{
//     buttonStr += `<button class="pageNumber" type = "button" id="page_${prev}" onclick="pagenation(``${totalCount}``,${prev})" > ���� </button>`

//     for(let i = firstNumber ; i <lastNumber; i++){
//       buttonStr += `<button class="pageNumber" type = "button" id="page_${i}" onclick="pagenation(``${totalCount}``,page_``${i})"> ${i} </button>`
//     }
//   }

//   buttonStr += `<button class="pageNumber" type = "button" id="page_${next}" onclick="pagenation(``${totalCount}``,${next})"> ���� </button>`

// }

const dateSearch=(jsonObj_)=>{

  var startDate = document.getElementById("startDate");
  var startDateStr = startDate.value;
  var startDateValue = new Date(startDateStr);
  var startDateMillis = startDateValue.getTime();

  var endDate = document.getElementById("endDate");
  var endDateStr = endDate.value;  
  var endDateValue = new Date(endDateStr);
  var endDateMillis = endDateValue.getTime();



  const content = jsonObj_.contents;

  const theadStr = "<thead><th>������ȣ</th><th>������</th><th>ȸ����ȣ</th><th>ȸ����</th><th>������</th><th>����</th><th>�ݳ�</th></thead>";
  let tbodyStr = "<tbody>";

  var nameResult = [];

  var tbodyStrArr = [];

  const fixedStartDate = new Date(2023,4,1); // ���� 0���� �����ϱ� ������ 5�� �����ؾ� 6���� ���´�, �ٵ� �� �ڵ忡���� 4�� �����ؾ��Ѵ� ������ ���߿� ã���..

  const fixedEndDate = new Date(2023,4,30);

  const fixedstartDateStr = fixedStartDate.toLocaleDateString('en-CA');
  const fixedendDateStr = fixedEndDate.toLocaleDateString('en-CA');



  for(let i =0;i<content.length;i++){

    const test = new Date(fixedEndDate.getTime() + Math.random() * (fixedEndDate.getTime() - fixedStartDate.getTime()));
    const rentdateStr = test.toLocaleDateString('en-CA');

      var tableRows = {
          book_no : content[i].book_no,
          title : content[i].title,
          memberNo : "00000"+i,
          author : content[i].author,
          rentDate : rentdateStr,  
          rental_check : content[i].rental_check,
          return_check : '<button class="btn_s_red"> �ݳ� </button>'

      };



      console.log(tbodyStrArr.length);

      if(startDateMillis <= test && endDateMillis >= test){
        //startDate ���� ���ų� ũ�� endDate ���� ���ų� ���� rentDate �� nameResult�� push
        console.log("push �ƴ�");
        console.log(tableRows.rentDate);
        console.log(startDateStr);
        console.log(endDateStr);
        console.log("-----------");
        tbodyStrArr.push(tableRows);  
      }
    }

    console.log(tbodyStrArr.length);

    nameResult = tbodyStrArr ;// �̷��� �ؼ� �Ѱܾ���

    const outputTotalNumEle = document.getElementById('totalNum');
    outputTotalNumEle.innerHTML = "<b>��ü</b>"+ nameResult.length + "<b>��</b>";


  for(let j =0;j<nameResult.length;j++){
    tbodyStr += setRow(nameResult[j]);
  }
  console.log(tbodyStr);

  tbodyStr+="</tbody>";
  return (theadStr + tbodyStr);
  
}
