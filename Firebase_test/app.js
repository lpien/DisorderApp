/*
 * This is only a test for implementing Firebase in javascript and convert data to csv files
 * Author: Shuyang Liu
*/

var Firebase    = require("firebase");
var fs          = require('fs');
var UserRootRef = new Firebase("https://brilliant-torch-1224.firebaseio.com/Users");

/*The csv data to be exported*/
var CSV         = "date_of_birth,full_name\n";

/*
 * Setting data
 * UserRootRef.set({
 *   alanisawesome: {
 *     date_of_birth: "June 23, 1912",
 *     full_name: "Alan Turing"
 *   },
 *   gracehop: {
 *     date_of_birth: "December 9, 1906",
 *     full_name: "Grace Hopper"
 *   }
 * });
 *
 * Adding data
 * UserRootRef.push({
 *   date_of_birth: "December 9, 1906",
 *   full_name: "Grace Hopper"
 * });
 *
 */

/*reading data, a callback function*/
UserRootRef.on("child_added", function(snapshot, prevChildKey)
{
    var u     = snapshot.val();;
    var date  = u.date_of_birth;
    var name  = u.full_name;

    var row   = date +','+name;
    CSV      += row+"\n";

    console.log('date: '+date);
    console.log('name: '+name);
    console.log("\n\n");

    /*write to data.csv file*/
    fs.writeFile('data.csv', CSV,function (err){
      if (err){
        throw err;
      }
      console.log("File saved!");
    });
  },function (errorObject){
    console.log("The read failed: " + errorObject.code);
});
