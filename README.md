# Sorting Visualisation 
## Example Sites
**Selection Sort**: https://damoebe.github.io/Sorting/selection/ \
**Bubble Sort**: https://damoebe.github.io/Sorting/bubble/ \
**Insertion Sort**: https://damoebe.github.io/Sorting/insertion/ 
## Customisation of displayed data via Java
To generate data.js files, git clone this repo and run the java code (/src/main/java/me/damoebe/simulation/WebSimulation.java) from a seperate class like Main. 
For example like this:
```
  WebSimulation.start(Sort::insertionSort, 20);
```
Its important that the content of the data.js file contains a var named 'json' storing a String that includes a SortData-Object's json-String.
