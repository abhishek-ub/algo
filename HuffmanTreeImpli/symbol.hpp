/***
 *  $Id$
 **
 *  File: symbol.hpp
 *  Created: Apr 17, 2015
 *
 *  Author: Jaroslaw Zola <jzola@buffalo.edu>
 *  Copyright (c) 2015 Jaroslaw Zola
 */

#ifndef SYMBOL_HPP
#define SYMBOL_HPP

struct symbol {
    explicit symbol(char av = 0, int ac = 0) : value(av), count(ac) { }
    char value; // actual symbol, by default 0 (empty)
    int count;  // count of the symbol, by default 0
}; // symbol

struct less_than{
	inline bool operator()(const symbol& lhs, const symbol& rhs) {
    return ((lhs.count < rhs.count) || (!(rhs.count < lhs.count) && (lhs.value < rhs.value)));
	} 
};
// compare two symbols
// symbol with a lower count is "less than" symbol with a higher count
inline bool operator<(const symbol& lhs, const symbol& rhs) {
    return ((lhs.count < rhs.count) || (!(rhs.count < lhs.count) && (lhs.value < rhs.value)));
} // operator<



template <typename T> struct bnode {
    explicit bnode(const T& t = T(), bnode* l = 0, bnode* r = 0)
        : value(t), left(l), right(r) { }

    T value;      // payload

    bnode* left;  // left child
    bnode* right; // right child
}; // struct bnode

struct bnode_comp
{
	inline bool operator()(const bnode<symbol> *lhs, const bnode<symbol> *rhs) {
    return ((lhs->value.count > rhs->value.count) || (!(rhs->value.count > lhs->value.count) && (lhs->value.value > rhs->value.value)));
	} 
};

#endif // SYMBOL_HPP