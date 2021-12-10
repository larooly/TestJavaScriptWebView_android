function callNumber(num) {
  console.log(num);
  return num
}

function sayHello(){
  console.log('hello');
  return 'Hello'
}

  function getmeNow(){
        var today = new Date();
        var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
        var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
        var dateTime = date+' '+time;

        return dateTime;
    }
