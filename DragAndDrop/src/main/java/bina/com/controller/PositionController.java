package bina.com.controller;

import java.io.IOException;
import java.util.List;

//import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bina.com.model.Position;
import bina.com.service.PositionService;

@Controller
public class PositionController {
	
	private static final Logger logger = Logger
			.getLogger(PositionController.class);

	public PositionController() {
		System.out.println(" PositionController()");
	}

//	@Autowired
//	private CustomerValidator customerValidator;

	@InitBinder("position")
	protected void initBinder(WebDataBinder binder) {
//		binder.addValidators(customerValidator);
	}

	/*@Autowired
	private CustomerValidator customerValidator;
	 */
	/*@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(customerValidator);
	}*/

	@Autowired
	private PositionService positionService;

	@RequestMapping(value = "/")
	public ModelAndView listPosition(ModelAndView model) throws IOException {
		List<Position> listPosition = positionService.getAllPosition();
		model.addObject("listPosition", listPosition);
		model.setViewName("home");
		return model;
	}

//	@RequestMapping(value = "/newPosition", method = RequestMethod.GET)
//	public ModelAndView newContact(ModelAndView model) {
//		Customer customer = new Customer();
//		model.addObject("position", customer);
//		model.setViewName("CustomerForm");
//		return model;
//	}

	/*@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public ModelAndView saveCustomer(@Valid @ModelAttribute Customer customer, BindingResult result,ModelAndView model ) {
		if (result.hasErrors()) {
			model.setViewName("error");
			return new ModelAndView("error");
		}
		if (customer.getId() == 0) { // if customer id is 0 then creating the
			// customer other updating the customer
			customerService.addCustomer(customer);
		} else {
			customerService.updateCustomer(customer);
		}
		return new ModelAndView("redirect:/");
	}
*/
//	@RequestMapping(value = "/savePosition", method = RequestMethod.POST)
//	public ModelAndView savePosition(@Valid @ModelAttribute Position position, BindingResult result,ModelAndView model ) {
//		if (result.hasErrors()) {
//			model.setViewName("error");
//			return new ModelAndView("error");
//		}
//		if (customer.getId() == 0) { // if customer id is 0 then creating the
			// customer other updating the customer
//			positionService.addPosition(position);
//			return new ModelAndView("redirect:/");
//		} else {
//			customerService.updateCustomer(customer);
		//	return new ModelAndView("redirect:/");
//		}
		
	}
	

//	@RequestMapping(value = "/deletePosition", method = RequestMethod.GET)
//	public ModelAndView deleteCustomer(HttpServletRequest request) {
//		int customerId = Integer.parseInt(request.getParameter("id"));
//		postionService.deletePosition(positionId);
//		return new ModelAndView("redirect:/");
//	}

//	@RequestMapping(value = "/editPosition", method = RequestMethod.GET)
//	public ModelAndView editContact(HttpServletRequest request) {
//		int customerId = Integer.parseInt(request.getParameter("id"));
//		Customer customer = postionService.getPosition(customerId);
//		ModelAndView model = new ModelAndView("CustomerForm");
//		model.addObject("customer", customer);
//
//		return model;
//	}





