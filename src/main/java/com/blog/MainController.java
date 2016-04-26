package com.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Controller

public class MainController {

	@Autowired 
		private BlogPostRepository blogRepo;

	@RequestMapping(value={"/","/index"}, method=RequestMethod.GET)
	public String index(ModelMap model)
	{
		Sort sort = new Sort(Sort.Direction.DESC,"date");
		ArrayList <BlogPost> bpl = (ArrayList<BlogPost>) blogRepo.findAll(sort);
		if(bpl.size() >0){
		 BlogPost bp= bpl.get(0);
		 System.out.println(bp.toString());
		}
		model.put("BLOGS",bpl);
		return "index";
	}


	@RequestMapping(value={"/searchIndex"}, method=RequestMethod.POST)
	public String searchIndex(ModelMap model, @RequestParam("search") String search)
	{
		System.out.println("searchIndex");
		Sort sort = new Sort(Sort.Direction.DESC,"date");
		ArrayList <BlogPost> bpl = (ArrayList<BlogPost>) blogRepo.findByTitle(sort,search);
		System.out.println("bpl called ");
		if(bpl.size() >0){
		 BlogPost bp= bpl.get(0);
		 System.out.println(bp.toString());
		} else 
		{
			 ArrayList <String> tags = new ArrayList<String>();
			 tags.add(search);
			 bpl = (ArrayList<BlogPost>) blogRepo.findByTags(sort,tags);
		}
		model.put("BLOGS",bpl);
		return "index";
	}

	@RequestMapping(value="/aboutUs")
	public String aboutUs()
	{
		return "aboutUs";
	}

	@RequestMapping(value="/blog_post{title}", method=RequestMethod.GET)
	public ModelMap blogByTitle(@PathVariable String title) 
	{
	  BlogPost bp = blogRepo.findByTitle(title);
	  ModelMap model = new ModelMap();
	  model.put("BLOG_TITLE",bp.getTitle());
	  model.put("BLOG_AUTHOR",bp.getAuthor());
	  model.put("BLOG_BODY",bp.getBody());
	  model.put("BLOG_TAGS",bp.getTags());
	  model.put("BLOG_SUMMARY",bp.getSummary());
	  return model;
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model,HttpServletRequest request)
	{	
		System.out.println(request.getRemoteAddr());
	
		System.out.println("Login controller");
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPost(Model model)
	{	
		//model.addAttribute("lc", new LoginCredentials());
		System.out.println("Login POST controller");
		model.addAttribute("bp",new BlogPost());
		return "newPost";
	}
	
	@RequestMapping("/login-error.html")
	public String loginError(Model model) {
		System.out.println("ADDING LOGING ERROR");
	    model.addAttribute("loginError", true);
	    return "login";
	}
	
	@RequestMapping("/error.html")
	  public String error(HttpServletRequest request, Model model) {
	    model.addAttribute("errorCode", request.getAttribute("javax.servlet.error.status_code"));
	    Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
	    String errorMessage = null;
	    if (throwable != null) {
	      errorMessage = throwable.getMessage();
	    }
	    model.addAttribute("errorMessage", errorMessage);
	    return "error";
	 }
	
	@RequestMapping(value="/newPost", method = RequestMethod.GET)
	public String isLoggedIn( Model model)
	{
		model.addAttribute("bp",new BlogPost());
		System.out.println("lc is not admin");
		return "newPost";
	}

	@RequestMapping(value="/blog_post{tags}", method=RequestMethod.GET)
	public ModelMap blogByTitle(@PathVariable ArrayList<String> tags) 
	{
	  ArrayList<BlogPost> bpl = (ArrayList<BlogPost>) blogRepo.findByTags(tags);
	  ModelMap mp = new ModelMap();
	  mp.put("BLOGS",bpl);
	  return mp;
	}

	@RequestMapping(value="/newPost", method=RequestMethod.POST)
    public String ReturnUrl (@ModelAttribute BlogPost bp, Model model) {
        model.addAttribute("bp", bp);
        System.out.println("ATTEMPTING TO SAVE BLOG POST");
        System.out.println("BP: title: "+bp.getTitle()+"author: "+bp.getAuthor() +"Date"+bp.getDate()+"body:"+bp.getBody()+"summary: "+bp.getSummary());
        blogRepo.save(bp);
        
        return "index";
   }

	@RequestMapping("/videos")
	public String videos(ModelMap model) 
	{
		//could  do foo. But it's all static
		return "videos";
	}

	@RequestMapping(value="/blogPost" , method=RequestMethod.GET)
	public String getBlogPosts(ModelMap model, @RequestParam("getBlogId") String blogId) 
	{
		System.out.println("blogId: "+blogId);
		BlogPost bp = blogRepo.findById(blogId);
		model.put("bp",bp);
		return "blogPost";
	}
}
