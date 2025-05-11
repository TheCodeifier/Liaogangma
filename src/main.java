import java.util.Scanner;

abstract class MessageSender {
    public final void verzend() {
        connect();
        sendMessage();
        disconnect();
    }

    protected abstract void connect();
    protected abstract void sendMessage();
    protected abstract void disconnect();
}

class EmailSender extends MessageSender {
    @Override
    protected void connect() {
        System.out.println("Email: Verbinden met mailserver...");
    }

    @Override
    protected void sendMessage() {
        System.out.println("Email: Bericht verzenden...");
    }

    @Override
    protected void disconnect() {
        System.out.println("Email: Verbinding verbreken.");
    }
}

class SMSSender extends MessageSender {
    @Override
    protected void connect() {
        System.out.println("SMS: Verbinden met SMS-gateway...");
    }

    @Override
    protected void sendMessage() {
        System.out.println("SMS: Bericht verzenden...");
    }

    @Override
    protected void disconnect() {
        System.out.println("SMS: Verbinding verbreken.");
    }
}

class PushNotificationSender extends MessageSender {
    @Override
    protected void connect() {
        System.out.println("Pushmelding: Verbinden met pushserver...");
    }

    @Override
    protected void sendMessage() {
        System.out.println("Pushmelding: Bericht verzenden...");
    }

    @Override
    protected void disconnect() {
        System.out.println("Pushmelding: Verbinding verbreken.");
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kies een methode om het bericht te versturen: email, SMS, of pushmelding");
        String keuze = scanner.nextLine().toLowerCase();

        MessageSender sender;

        switch (keuze) {
            case "email":
                sender = new EmailSender();
                break;
            case "SMS":
                sender = new SMSSender();
                break;
            case "push":
                sender = new PushNotificationSender();
                break;
            default:
                System.out.println("Ongeldige keuze.");
                scanner.close();
                return;
        }

        sender.verzend();
        scanner.close();
    }
}