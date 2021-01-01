package com.yu.st.controller.trade;

import com.yu.st.controller.Message;
import com.yu.st.dao.impl.itemInfo;
import com.yu.st.entity.Category;
import com.yu.st.entity.Conditions;
import com.yu.st.entity.Item;
import com.yu.st.entity.State;
import com.yu.st.service.impl.ItemService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author        :hhyygg2009
 * @date        :Created in 2020/12/22 15:04
 * @package :${PACKAGE_NAME}
 * @description:
 * @modified By：
 * @version:
 */
@WebServlet("/trade/release")
public class ItemEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> iItem;
        List<Category> category;
        List<Conditions> conditions;
        List<State> state;
        String id;

        id=request.getParameter("id");

        ItemService itemService=new ItemService();

        if(id!=null) {
            Item item = itemService.getItem(Integer.parseInt(id));
            request.setAttribute("item", item);
        }

        Message message=new Message();

        category = itemInfo.getAllCategory();
        conditions =  itemInfo.getAllConditions();
        state = itemInfo.getAllState();

        request.setAttribute("categorys",category);
        request.setAttribute("conditions",conditions);
        request.setAttribute("state",state);

        RequestDispatcher rd=request.getRequestDispatcher("/trade/release.jsp");
        rd.forward(request,response);

    }
}
