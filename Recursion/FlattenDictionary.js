/* This question is from Pramp

Given a dictionary, dict, write a function, flattenDictionary, that 
returns a flattened version of it. If a certain key is empty, it should
be excluded from the output (see e in example below).

Sample Input: dict = {
            "Key1" : "1",
            "Key2" : {
                "a" : "2",
                "b" : "3",
                "c" : {
                    "d" : "3",
                    "e" : {
                        "" : "1"
                    }
                }
            }
        }
Sample Output: {
            "Key1" : "1",
            "Key2.a" : "2",
            "Key2.b" : "3",
            "Key2.c.d" : "3",
            "Key2.c.e" : "1"
        } */

//Recursive Solution:
//O(n) Time | O(n) Space
function flattenDictionary(dict) {
  let flat = {};
  // iterate through each property in the dict object, if the value is another dict object,
  // recursively call flattenDictionary on the newDict

  for (let key in dict) {
    if (typeof dict[key] === "object") {
      let newDict = flattenDictionary(dict[key]);
      // iterate through each new key in the newDict

      for (let newKey in newDict) {
        // if the original key was empty, the flat object will hold the newKey instead,
        if (key === "") {
          flat[newKey] = newDict[newKey];
          // if the new key is empty, the flat object will hold the original key in place
        } else if (newKey === "") {
          flat[key] = newDict[newKey];
          // else the flat object will have concatenated keys that correspond to the value
        } else {
          flat[`${key}.${newKey}`] = newDict[newKey];
        }
      }
      // when iterating through each property in the dict object, if the value is primitive
      // store that key value pair into the flat object
    } else {
      flat[key] = dict[key];
    }
  }
  return flat;
}

console.log(
  flattenDictionary({
    Key1: "1",
    Key2: { a: "2", b: "3", c: { d: "3", e: { "": "1" } } }
  })
);

console.log(flattenDictionary({ "": { a: "1" }, b: "3" }));

console.log(
  flattenDictionary({
    Key1: "1",
    Key2: { a: "2", b: "3", c: { d: "3", e: { f: "4" } } }
  })
);

console.log(
  flattenDictionary({ a: { b: { c: { d: { e: { f: { "": "awesome" } } } } } } })
);
