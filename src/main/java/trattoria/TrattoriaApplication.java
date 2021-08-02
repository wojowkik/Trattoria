package trattoria;

import trattoria.api.AppController;

/*
virtual trattoria (simple app to order a pizza)
 */
public class TrattoriaApplication
{
    public static void main(String[] args) {
        AppController appController = new AppController();
        appController.start();
    }
}
