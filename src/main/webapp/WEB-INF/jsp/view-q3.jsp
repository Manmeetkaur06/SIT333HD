<!DOCTYPE html>
<html>
<head>
    <title>Q3 Multiplication</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; margin: 0; padding: 40px; }
        .card { max-width: 480px; margin: auto; background: white; padding: 28px; border-radius: 10px; box-shadow: 0 4px 14px rgba(0,0,0,0.10); }
        label { display: block; margin-top: 14px; font-weight: bold; }
        input { width: 100%; box-sizing: border-box; padding: 10px; margin-top: 6px; border: 1px solid #cbd5e1; border-radius: 6px; }
        input[type="submit"] { margin-top: 20px; background: #2563eb; color: white; border: none; cursor: pointer; font-weight: bold; }
        .error { color: #b91c1c; font-weight: bold; }
    </style>
</head>
<body>
<div class="card">
    <h2>Q3 - Multiplication</h2>
    <p>Enter two numbers and calculate the multiplication result.</p>
    <p class="error">${message}</p>

    <form id="q3Form" action="/q3" method="post" novalidate>
        <label for="number1">First number</label>
        <input type="number" step="0.01" id="number1" name="number1">

        <label for="number2">Second number</label>
        <input type="number" step="0.01" id="number2" name="number2">

        <label for="answer">MULTIPLY</label>
        <input type="number" step="0.01" id="answer" name="answer">

        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
