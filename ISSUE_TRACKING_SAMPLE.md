# Issue Tracking Sample for GitHub Issues or Jira

## Issue title
Selenium functional test failed because Q3 redirected to success instead of Q4

## Issue type
Bug

## Priority
High

## Assignee
Manmeet Kaur

## Description
During Selenium functional testing, the full STEM game flow failed after the Q3 multiplication page. The expected behaviour was that a correct Q3 answer should redirect the user to the first new date utility page `/q4`. The actual behaviour redirected the user directly to `/success`, which skipped the two date utility problems and the science problem.

## Steps to reproduce
1. Start the STEM game application on `localhost:8080`.
2. Login using valid credentials.
3. Complete Q1 addition correctly.
4. Complete Q2 subtraction correctly.
5. Complete Q3 multiplication correctly.
6. Observe the next page.

## Expected result
The application should redirect to `/q4` after a correct Q3 answer.

## Actual result
The application redirected to `/success`, skipping Q4, Q5 and Q6.

## Fix applied
Updated `RoutingServlet.java` so that the Q3 POST handler redirects to `/q4` instead of `/success`.

## Resolution evidence
After the fix, the Selenium full-flow test passed and confirmed navigation through `/q4`, `/q5`, `/q6` and `/success`.
