package web.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import web.service.DateQuestionService;
import web.service.LoginService;
import web.service.MathQuestionService;
import web.service.ScienceQuestionService;

@Controller
@RequestMapping("/")
public class RoutingServlet {

    @GetMapping("/")
    public String welcome() {
        System.out.println("Welcome page...");
        return "view-welcome";
    }

    @GetMapping("/login")
    public String loginView() {
        System.out.println("Login page...");
        return "view-login";
    }

    @PostMapping("/login")
    public RedirectView login(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String username = request.getParameter("username");
        String password = request.getParameter("passwd");
        String dob = request.getParameter("dob");

        if (LoginService.login(username, password, dob)) {
            return new RedirectView("/q1", true);
        }

        redirectAttributes.addFlashAttribute("message", "Incorrect credentials. Please try again.");
        return new RedirectView("/login", true);
    }

    @GetMapping("/q1")
    public String q1View() {
        System.out.println("Q1 addition page...");
        return "view-q1";
    }

    @PostMapping("/q1")
    public RedirectView q1Submit(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String answer = request.getParameter("answer");

        double correctAnswer = MathQuestionService.q1Addition(number1, number2);

        if (MathQuestionService.isAnswerCorrect(answer, correctAnswer)) {
            return new RedirectView("/q2", true);
        }

        redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
        return new RedirectView("/q1", true);
    }

    @GetMapping("/q2")
    public String q2View() {
        System.out.println("Q2 subtraction page...");
        return "view-q2";
    }

    @PostMapping("/q2")
    public RedirectView q2Submit(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String answer = request.getParameter("answer");

        double correctAnswer = MathQuestionService.q2Subtraction(number1, number2);

        if (MathQuestionService.isAnswerCorrect(answer, correctAnswer)) {
            return new RedirectView("/q3", true);
        }

        redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
        return new RedirectView("/q2", true);
    }

    @GetMapping("/q3")
    public String q3View() {
        System.out.println("Q3 multiplication page...");
        return "view-q3";
    }

    @PostMapping("/q3")
    public RedirectView q3Submit(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String answer = request.getParameter("answer");

        double correctAnswer = MathQuestionService.q3Multiplication(number1, number2);

        if (MathQuestionService.isAnswerCorrect(answer, correctAnswer)) {
            return new RedirectView("/q4", true);
        }

        redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
        return new RedirectView("/q3", true);
    }

    @GetMapping("/q4")
    public String q4View() {
        System.out.println("Q4 date after page...");
        return "view-q4";
    }

    @PostMapping("/q4")
    public RedirectView q4Submit(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String startDate = request.getParameter("startDate");
        String days = request.getParameter("days");
        String answerDate = request.getParameter("answerDate");

        String correctAnswer = DateQuestionService.findDateAfter(startDate, days);

        if (DateQuestionService.isDateAnswerCorrect(answerDate, correctAnswer)) {
            return new RedirectView("/q5", true);
        }

        redirectAttributes.addFlashAttribute("message", "Wrong date answer, try again.");
        return new RedirectView("/q4", true);
    }

    @GetMapping("/q5")
    public String q5View() {
        System.out.println("Q5 date before page...");
        return "view-q5";
    }

    @PostMapping("/q5")
    public RedirectView q5Submit(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String startDate = request.getParameter("startDate");
        String days = request.getParameter("days");
        String answerDate = request.getParameter("answerDate");

        String correctAnswer = DateQuestionService.findDateBefore(startDate, days);

        if (DateQuestionService.isDateAnswerCorrect(answerDate, correctAnswer)) {
            return new RedirectView("/q6", true);
        }

        redirectAttributes.addFlashAttribute("message", "Wrong date answer, try again.");
        return new RedirectView("/q5", true);
    }

    @GetMapping("/q6")
    public String q6View() {
        System.out.println("Q6 science page...");
        return "view-q6";
    }

    @PostMapping("/q6")
    public RedirectView q6Submit(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String mass = request.getParameter("mass");
        String volume = request.getParameter("volume");
        String answer = request.getParameter("answer");

        double correctAnswer = ScienceQuestionService.calculateDensity(mass, volume);

        if (ScienceQuestionService.isScienceAnswerCorrect(answer, correctAnswer)) {
            return new RedirectView("/success", true);
        }

        redirectAttributes.addFlashAttribute("message", "Wrong science answer, try again.");
        return new RedirectView("/q6", true);
    }

    @GetMapping("/success")
    public String successView() {
        System.out.println("Success page...");
        return "view-success";
    }
}
