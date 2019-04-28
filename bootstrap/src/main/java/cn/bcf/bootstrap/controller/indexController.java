package cn.bcf.bootstrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/28 14:48
 **/
@Controller
@RequestMapping("/index")
public class indexController {

    @RequestMapping("/layouts-normal")
    public ModelAndView layoutsNormal(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/layouts/layouts-normal");
        return view;
    }

    @RequestMapping("/layouts-fixed-header")
    public ModelAndView layoutsFixedHeader(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/layouts/layouts-fixed-header");
        return view;
    }

    @RequestMapping("/layouts-fixed-sidebar")
    public ModelAndView layoutsFixedSidebar(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/layouts/layouts-fixed-sidebar");
        return view;
    }

    @RequestMapping("/layouts-hidden-sidebar")
    public ModelAndView layoutsHiddenSidebar(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/layouts/layouts-hidden-sidebar");
        return view;
    }

    @RequestMapping("/alerts")
    public ModelAndView alerts(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/UI/alerts");
        return view;
    }

    @RequestMapping("/buttons")
    public ModelAndView buttons(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/UI/buttons");
        return view;
    }

    @RequestMapping("/cards")
    public ModelAndView cards(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/UI/cards");
        return view;
    }

    @RequestMapping("/modals")
    public ModelAndView modals(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/UI/modals");
        return view;
    }

    @RequestMapping("/progress-bars")
    public ModelAndView progressBars(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/UI/progress-bars");
        return view;
    }

    @RequestMapping("/tabs")
    public ModelAndView tabs(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/UI/tabs");
        return view;
    }

    @RequestMapping("/widgets")
    public ModelAndView widgets(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/UI/widgets");
        return view;
    }

    @RequestMapping("/charts")
    public ModelAndView charts(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/charts/charts");
        return view;
    }

    @RequestMapping("/forms")
    public ModelAndView forms(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/forms");
        return view;
    }

    @RequestMapping("/tables")
    public ModelAndView tables(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/tables");
        return view;
    }


    @RequestMapping("/blank")
    public ModelAndView blank(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/pages/blank");
        return view;
    }

    @RequestMapping("/invoice")
    public ModelAndView invoice(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/pages/invoice");
        return view;
    }

    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/pages/login");
        return view;
    }

    @RequestMapping("/register")
    public ModelAndView register(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/pages/register");
        return view;
    }

    @RequestMapping("/settings")
    public ModelAndView setting(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/pages/setting");
        return view;
    }

    @RequestMapping("/404")
    public ModelAndView connotFind(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/pages/404");
        return view;
    }

    @RequestMapping("/505")
    public ModelAndView serverError(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/pages/505");
        return view;
    }
}
