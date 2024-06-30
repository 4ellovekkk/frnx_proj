<!DOCTYPE html>
<html>
<head>
  <title>JSON Test</title>
</head>
<body>
<button onclick="sendCorrectJson()">Send Correct JSON</button>
<button onclick="sendIncorrectJson()">Send Incorrect JSON</button>
<button onclick="showCustomJsonForm()">Send Custom JSON</button>

<div id="customJsonForm" style="display:none;">
  <h2>Custom JSON Form</h2>
  <form id="jsonForm">
    <label for="request_id">Request ID:</label>
    <input type="text" id="request_id" name="request_id"><br>
    <label for="loan_id">Loan ID:</label>
    <input type="text" id="loan_id" name="loan_id"><br>
    <label for="terminal_id">Terminal ID:</label>
    <input type="text" id="terminal_id" name="terminal_id"><br>
    <label for="merchant_id">Merchant ID:</label>
    <input type="text" id="merchant_id" name="merchant_id"><br>
    <label for="nspc_trans_id">NSPC Trans ID:</label>
    <input type="text" id="nspc_trans_id" name="nspc_trans_id"><br>
    <label for="amount">Amount:</label>
    <input type="text" id="amount" name="amount"><br>
    <label for="commission_amount">Commission Amount:</label>
    <input type="text" id="commission_amount" name="commission_amount"><br>
    <label for="payment_type">Payment Type:</label>
    <input type="text" id="payment_type" name="payment_type"><br>
    <label for="card_type">Card Type:</label>
    <input type="text" id="card_type" name="card_type"><br>
    <label for="authorization_code">Authorization Code:</label>
    <input type="text" id="authorization_code" name="authorization_code"><br>
    <label for="payment_date">Payment Date:</label>
    <input type="text" id="payment_date" name="payment_date"><br>
    <label for="operation_number">Operation Number:</label>
    <input type="text" id="operation_number" name="operation_number"><br>
    <button type="button" onclick="sendCustomJson()">Send</button>
  </form>
</div>

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

  function showCustomJsonForm() {
    document.getElementById("customJsonForm").style.display = "block";
  }

  function sendCustomJson() {
    const form = document.getElementById('jsonForm');
    const formData = new FormData(form);
    const jsonObject = {};
    formData.forEach((value, key) => {
      jsonObject[key] = value;
    });

    fetch('/frnx_proj/api/validate', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(jsonObject)
    }).then(response => response.json()).then(data => alert(JSON.stringify(data)));
  }
</script>
</body>
</html>
