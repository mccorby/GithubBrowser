XING Android Coding Challenge
=============================

This challenge would give us an idea about your coding skills. You get access to this 
repository for 24 hours. The challenge can be finished in ~3 hours.


Steps
-----

1. Clone this repository. Use it as your working directory.
2. Bootstrap a new Android app.
3. Request the GitHub API to show [XING's public repositories][1] and parse the JSON
   response.
4. Display a list of repositories, each entry should show
    - repo name
    - description
    - login of the owner
5. Request only 10 repos at a time. Use an endless list with a load more mechanism. The
   load more should be triggered when the scrolling is close to reaching the end of the
list. Check the [pagination documentation][2].
6. Cache the repos (preferably in a content provider).
7. Show a light green background if the `fork` flag is false or missing, a white one
   otherwise.
8. On a long click on a list item show a dialog to ask if go to repository `html_url` or
   owner `html_url` which is opened then in the browser.


Additional notes
----------------

- Important for us is code efficiency, following of best practices & code readability.
- Don't focus too much on the design.
- We would prefer if you'd use a loader and/or a content observer mechanism when you
  display the items.
- We would prefer if you'd not use libraries for storage, network and tasks
- Make sure the app runs on a ICS+ device.
- If your API request limit exceeds, you can generate and use a personal access token [here](https://github.com/settings/applications) and add `?access_token=<YOUR_ACCESS_TOKEN>` to the request URLs.
- If you have any final comments about your result please let us know via final_notes.txt



Bonus points
------------
Provide a comprehensive git history.


  [1]: https://api.github.com/users/xing/repos
  [2]: https://developer.github.com/v3/#pagination
