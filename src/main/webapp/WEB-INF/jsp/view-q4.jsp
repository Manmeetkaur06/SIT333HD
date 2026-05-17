<!DOCTYPE html>
<html>
<head>
    <title>Q4 Date After</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; margin: 0; padding: 40px; }
        .card { max-width: 520px; margin: auto; background: white; padding: 28px; border-radius: 10px; box-shadow: 0 4px 14px rgba(0,0,0,0.10); }
        label { display: block; margin-top: 14px; font-weight: bold; }
        input { width: 100%; box-sizing: border-box; padding: 10px; margin-top: 6px; border: 1px solid #cbd5e1; border-radius: 6px; }
        input[type="submit"] { margin-top: 20px; background: #7c3aed; color: white; border: none; cursor: pointer; font-weight: bold; }
        .error { color: #b91c1c; font-weight: bold; }
    </style>
</head>
<body>
<div class="card">
    <h2>Q4 - Date Utility: Date After</h2>
    <p>Enter a start date, number of days, and the date after that many days.</p>
    <p class="error">${message}</p>

    <form id="q4Form" action="/q4" method="post" novalidate>
        <label for="startDate">Start date</label>
        <input type="date" id="startDate" name="startDate">

        <label for="days">Number of days after</label>
        <input type="number" id="days" name="days">

        <label for="answerDate">Your answer date</label>
        <input type="date" id="answerDate" name="answerDate">

        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
