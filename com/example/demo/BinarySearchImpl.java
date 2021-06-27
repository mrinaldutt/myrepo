package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {
	
	@Autowired
	private Sorting sort;
	
	public BinarySearchImpl(Sorting sort) {
		super();
		this.sort = sort;
	}

	public int binrySearch(int [] numbers, int numbertoSearchFor ) {
	//implement the sorting an array
	//searching the array
	//Return an array
	
		return sort.binrySearch(numbers, numbertoSearchFor);
	}
}
