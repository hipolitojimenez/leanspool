Scenario: All jobs tree tests.

Given the user opens the url http://localhost:8080/leanspool/jobs-management.html
When the user waits for page to be loaded
And the user clicks the first node in the tree allJobsTree
And the user waits for the tree allJobsTree to be loaded
And the user orders the grid by the Job ID field
And the user waits for the tree allJobsTree to be loaded
Then the user views jobId01 as the first grid row text
And the page title is Lean Spooler


Scenario: Jobs by status tree tests.

Given the user opens the url http://localhost:8080/leanspool/jobs-management.html
When the user waits for page to be loaded
And the user clicks on the jobsByStatusPanel accordion tab
And the user double clicks the first node in the tree jobsByStatusTree
And the user clicks the first node in the tree jobsByStatusTree_New
And the user waits for the tree jobsByStatusTree to be loaded
And the user orders the grid by the Job ID field
And the user waits for the tree jobsByStatusTree to be loaded
Then the user views jobId01 as the first grid row text
And the page title is Lean Spooler


Scenario: Jobs by printer tree tests.

Given the user opens the url http://localhost:8080/leanspool/jobs-management.html
When the user waits for page to be loaded
And the user clicks on the jobsByPrinterPanel accordion tab
And the user double clicks the first node in the tree jobsByPrinterTree
And the user clicks the first node in the tree jobsByPrinterTree_Printer01
And the user waits for the tree jobsByPrinterTree to be loaded
And the user orders the grid by the Job ID field
And the user waits for the tree jobsByPrinterTree to be loaded
Then the user views jobId01 as the first grid row text
And the page title is Lean Spooler
