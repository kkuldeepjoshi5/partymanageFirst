package com.eventManagment.Controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;

import com.eventManagment.Entity.Event;
import com.eventManagment.Manager.EventManager;
import com.eventManagment.Utility.Message;
import com.eventManagment.vo.EventVO;

@Controller
@RequestMapping("/event")
public class EventController implements ServletContextAware {

	
	private EventManager eventManager;

	public EventManager getEventManager() {
		return eventManager;
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	@Autowired
	private ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;

	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public  Message delete(HttpServletRequest request) {
		try{
			Long eventId =Long.parseLong(request.getParameter("eventId"));
			return eventManager.delete(eventId);
		}catch(Exception e){
			e.printStackTrace();
			return (new Message("Exception:"+e));
		}

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public  Message insert(@RequestBody EventVO eventVO,HttpServletRequest request)	throws IOException {

		Event event=eventManager.craeteEventFromVO(eventVO);

		return eventManager.insert(event);
	}


	@RequestMapping("/getAll")
	@ResponseBody
	public Map<String,Object> getAll() {
		Map<String,Object> resultMap=new HashMap<String, Object>();
		List<EventVO> eventVOs=new ArrayList<EventVO>();
		List<Event> events=eventManager.getAll();
		for (Event event : events) {
			EventVO eventVO=eventManager.craeteVOFromEvent(event);
			eventVOs.add(eventVO);
		}
		resultMap.put("eventVOs", eventVOs);
		return resultMap;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Message update(@RequestBody EventVO eventVO) {

		Event event=eventManager.craeteEventFromVO(eventVO);
		return eventManager.update(event);
	}



}
