<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; margin: 0; padding: 40px; }
        .card { max-width: 430px; margin: auto; background: white; padding: 28px; border-radius: 10px; box-shadow: 0 4px 14px rgba(0,0,0,0.10); }
        h2 { margin-top: 0; color: #1f2937; }
        label { display: block; margin-top: 14px; font-weight: bold; color: #374151; }
        input { width: 100%; box-sizing: border-box; padding: 10px; margin-top: 6px; border: 1px solid #cbd5e1; border-radius: 6px; }
        input[type="submit"] { margin-top: 20px; background: #16a34a; color: white; border: none; cursor: pointer; font-weight: bold; }
        .error { color: #b91c1c; font-weight: bold; }
        .hint { color: #6b7280; font-size: 13px; }
    </style>
</head>
<body>
<div class="card">
    <h2>User Login</h2>
    <p class="hint">Test login: username <strong>ahsan</strong>, password <strong>ahsan_pass</strong>.</p>
    <p class="error">${message}</p>

    <form id="loginForm" action="/login" method="post" novalidate>
        <label for="username">User name</label>
        <input type="text" id="username" name="username">

        <label for="passwd">Password</label>
        <input type="password" id="passwd" name="passwd">

        <label for="dob">Date of birth</label>
        <input type="date" id="dob" name="dob">

        <input type="submit" value="Login">
    </form>
</div>
</body>
</html>
