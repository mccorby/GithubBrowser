Github Challenge
=============================
This app was done (in this state) for an position as Android Developer.

I first defined the architecture of the app following Uncle Bob's Clean Architecture
Then went into the specificity of each case.
 Note that some parts are not implemented as you would have done it with more time.

 Anyway, I would using this app as a showcase of my work and I will be updating it

- Request the GitHub API to show [users's public repositories][1] and parse the JSON
   response.
- Display a list of repositories, each entry should show
    - repo name
    - description
    - login of the owner
- Request only 10 repos at a time. Use an endless list with a load more mechanism. The
   load more should be triggered when the scrolling is close to reaching the end of the
list. Check the pagination documentation.
- Cache the repos in a content provider.
- Show a light green background if the `fork` flag is false or missing, a white one
   otherwise.
- On a long click on a list item show a dialog to ask if go to repository `html_url` or
   owner `html_url` which is opened then in the browser.

