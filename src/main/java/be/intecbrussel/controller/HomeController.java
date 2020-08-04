package be.intecbrussel.controller;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        if(error != null) {
            model.addAttribute("error", "El nombre de usuario o contraseña son invalidos");
        }
        if(logout != null) {
            model.addAttribute("msg", "La sesion ha finalizado con exito");
        }

        return "login";
    }
}
