import java.util.*;
public class BurnNode {
      
}













// Burn the binary tree starting from the target node
// Difficulty Level : Hard
// Last Updated : 25 Sep, 2021
// Given a binary tree and target node. By giving the fire to the target node and fire starts to spread in a complete tree. The task is to print the sequence of the burning nodes of a binary tree.
// Rules for burning the nodes : 

// Fire will spread constantly to the connected nodes only.
// Every node takes the same time to burn.
// A node burns only once.
// Examples: 

// Attention reader! Don’t stop learning now. Get hold of all the important DSA concepts with the DSA Self Paced Course at a student-friendly price and become industry ready.  To complete your preparation from learning a language to DS Algo and many more,  please refer Complete Interview Preparation Course.

// In case you wish to attend live classes with experts, please refer DSA Live Classes for Working Professionals and Competitive Programming Live for Students.

// Input : 
//                        12
//                      /     \
//                    13       10
//                           /     \
//                        14       15
//                       /   \     /  \
//                      21   24   22   23
// target node = 14

// Output :
// 14
// 21, 24, 10
// 15, 12
// 22, 23, 13

// Explanation : First node 14 burns then it gives fire to it's 
// neighbors(21, 24, 10) and so on. This process continues until 
// the whole tree burns.


// Input :
//                        12
//                      /     \
//                   19        82
//                  /        /     \
//                41       15       95
//                  \     /         /  \
//                   2   21        7   16
// target node = 41

// Output :
// 41
// 2, 19
// 12
// 82
// 15, 95
// 21, 7, 16