<!DOCTYPE html>
<html>
<head>
    <title>Q6 Science Problem</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; margin: 0; padding: 40px; }
        .card { max-width: 520px; margin: auto; background: white; padding: 28px; border-radius: 10px; box-shadow: 0 4px 14px rgba(0,0,0,0.10); }
        label { display: block; margin-top: 14px; font-weight: bold; }
        input { width: 100%; box-sizing: border-box; padding: 10px; margin-top: 6px; border: 1px solid #cbd5e1; border-radius: 6px; }
        input[type="submit"] { margin-top: 20px; background: #ea580c; color: white; border: none; cursor: pointer; font-weight: bold; }
        .error { color: #b91c1c; font-weight: bold; }
    </style>
</head>
<body>
<div class="card">
    <h2>Q6 - Science Problem: Density</h2>
    <p>Use the formula: Density = Mass / Volume.</p>
    <p class="error">${message}</p>

    <form id="q6Form" action="/q6" method="post" novalidate>
        <label for="mass">Mass</label>
        <input type="number" step="0.01" id="mass" name="mass">

        <label for="volume">Volume</label>
        <input type="number" step="0.01" id="volume" name="volume">

        <label for="answer">Density</label>
        <input type="number" step="0.01" id="answer" name="answer">

        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
