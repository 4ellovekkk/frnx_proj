<!DOCTYPE html>
<html>
<head>
  <title>JSON Test</title>
</head>
<body>
<button onclick="sendCorrectJson()">Send Correct JSON</button>
<button onclick="sendIncorrectJson()">Send Incorrect JSON</button>
<button onclick="sendCustomJson()">Send Custom JSON</button>

<script>
  function sendCorrectJson() {
    fetch('/frnx_proj/api/validate', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        "request_id": "3285950",
        "loan_id": "41515070",
        "terminal_id": "91600062",
        "merchant_id": "9160006245",
        "nspc_trans_id": "7415627",
        "amount": "80000",
        "commission_amount": "1",
        "payment_type": "4",
        "card_type": "HUMO",
        "authorization_code": "6FE05113-6183-403F-9283-CE08499121E4",
        "payment_date": "27.03.2020",
        "operation_number": "45451"
      })
    }).then(response => response.json()).then(data => alert(JSON.stringify(data)));
  }

  function sendIncorrectJson() {
    fetch('/frnx_proj/api/validate', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        "request_id": "",
        "loan_id": "41515070",
        "terminal_id": "91600062",
        "merchant_id": "9160006245",
        "nspc_trans_id": "7415627",
        "amount": "eight thousand",
        "commission_amount": "1",
        "payment_type": "4",
        "card_type": "HUMO",
        "authorization_code": "6FE05113-6183-403F-9283-CE08499121E4",
        "payment_date": "27.03.2020",
        "operation_number": "45451"
      })
    }).then(response => response.json()).then(data => alert(JSON.stringify(data)));
  }

  function sendCustomJson() {
    const json = prompt("Enter your JSON:");
    fetch('/frnx_proj/api/validate', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: json
    }).then(response => response.json()).then(data => alert(JSON.stringify(data)));
  }
</script>
</body>
</html>
