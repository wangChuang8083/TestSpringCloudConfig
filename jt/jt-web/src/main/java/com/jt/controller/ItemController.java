package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.pojo.Item;
import com.jt.pojo.ItemDesc;
import com.jt.service.ItemDescService;
import com.jt.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {

	@Autowired
    private ItemService itemService;
	@Autowired
	private ItemDescService itemDescService;
	@RequestMapping("/{id}")
	public String findItemById(@PathVariable Long id,Model model) {
		
		Item item=itemService.findItemById(id);
		ItemDesc itemDesc=itemDescService.findItemDescById(id);
		model.addAttribute("itemDesc", itemDesc);
		model.addAttribute("item",item);
		return "item";
	}
}
