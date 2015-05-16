#ifndef A7_HPP
#define A7_HPP

#include "symbol.hpp"
#include <iostream>
#include <climits>
#include <queue>

// IMPLEMENT YOUR FUNCTION huffman_tree
template <typename Iter> bnode<symbol>* huffman_tree(Iter first, Iter last){

	std::priority_queue<bnode<symbol>*, std::vector <bnode<symbol> *>,bnode_comp> pr_queue; 


	while(first!= last){

		bnode<symbol> *incomingnode = new bnode<symbol>(*first);
		pr_queue.push(incomingnode);
		first++;
	}

	// while(!pr_queue.empty()){
	// 	//std::cout << pr_queue.top().value.value << " " << pr_queue.top().value.count << std::endl;
	// 	pr_queue.pop();
	// }
	//std::cout << "pushed to priority_queue" <<std::endl;
	if (pr_queue.size() == 0)
	{
		return NULL;
	}

	//std::cout << "the algo" <<std::endl;

	while(pr_queue.size() != 1){

		bnode<symbol> *s1 = pr_queue.top();
		pr_queue.pop();
		bnode<symbol> *s2 = pr_queue.top();
		pr_queue.pop();

		symbol newnodesym;
		newnodesym.value = UCHAR_MAX;
		newnodesym.count = s1->value.count + s2->value.count;
		bnode<symbol> *newnode = new bnode<symbol>(newnodesym);
		newnode->left  = s1;
		newnode->right = s2;

		pr_queue.push(newnode);


		//std::cout << "Iter" <<std::endl;
	}

	//std::cout << "final" <<std::endl;
	return pr_queue.top();	
}

// IMPLEMENT YOUR FUNCTION release_tree
void release_tree(bnode<symbol>* root){
	 if (root != 0) {
	 	release_tree(root->left);
    	release_tree(root->right);
	 	std::cout << "deleting root "  << root->value.count <<std::endl;
        delete(root);
        root = NULL;
    }

    
}

#endif // A7_HPP