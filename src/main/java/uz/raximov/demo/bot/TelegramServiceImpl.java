package uz.raximov.demo.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import uz.raximov.demo.Entity.User;
import uz.raximov.demo.Entity.Warehouse;
import uz.raximov.demo.Repository.UserRepository;
import uz.raximov.demo.Service.UserService;
import uz.raximov.demo.Service.WareHouseService;
import uz.raximov.demo.payload.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelegramServiceImpl implements TelegramService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    WareHouseService wareHouseService;

    Warehouse warehouse;

    @Override
    public SendMessage login(Update update) {

        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId()) //kimga yuboradi
                .setParseMode(ParseMode.MARKDOWN); //qanaqa format

        Optional<User> optionalUser = userRepository.findByChatId(update.getMessage().getChatId());

        if (optionalUser.isPresent()) {
            sendMessage.setText(Constant.WELCOME_TEXT);

            User user = optionalUser.get();
            user.setState(BotState.LOGIN);
            userRepository.save(user);
        } else {
            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup()
                    .setOneTimeKeyboard(true)
                    .setResizeKeyboard(true)
                    .setSelective(true);

            List<KeyboardRow> keyboardRows = new ArrayList<>();

            KeyboardRow keyboardRow = new KeyboardRow(); //qator
            KeyboardButton keyboardButton = new KeyboardButton(); //bitta button
            keyboardButton.setRequestContact(true); //contact

            keyboardButton.setText(Constant.SHARE_CONTACT);
            keyboardRow.add(keyboardButton);
            keyboardRows.add(keyboardRow);
            replyKeyboardMarkup.setKeyboard(keyboardRows);
            sendMessage.setText(Constant.CONTACT_TEXT);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
        }

        return sendMessage;
    }

    @Override
    public SendMessage shareContact(Update update) {

        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId()) //kimga yuboradi
                .setParseMode(ParseMode.MARKDOWN); //qanaqa format

        Optional<User> optionalUser = userRepository.findByChatId(update.getMessage().getChatId());
        User user;
        if (!optionalUser.isPresent()) {
            UserDTO userDTO = new UserDTO();
            userDTO.setFirstName(update.getMessage().getContact().getFirstName());
            userDTO.setLastName(update.getMessage().getContact().getLastName());
            userDTO.setPhoneNumber(update.getMessage().getContact().getPhoneNumber());
            userDTO.setChatId(update.getMessage().getChatId());
            userDTO.setPassword("123");
            user = userService.add(userDTO);

            sendMessage.setText(user.getFirstName() + " " + user.getLastName() + "! " + Constant.WELCOME_TEXT);

        } else {
            user = optionalUser.get();
            sendMessage.setText(Constant.BACK);
        }

        user.setState(BotState.SHARECONTACT);
        userRepository.save(user);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup()
                .setOneTimeKeyboard(true)
                .setResizeKeyboard(true)
                .setSelective(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow(); //qator
        KeyboardRow keyboardRow1 = new KeyboardRow(); //qator
        KeyboardButton keyboardButton = new KeyboardButton(); //bitta button
        KeyboardButton keyboardButton1 = new KeyboardButton(); //bitta button

        keyboardButton.setText(Constant.MAIN_MENU);
        keyboardButton1.setText(Constant.KATALOG);
        keyboardRow.add(keyboardButton);
        keyboardRow1.add(keyboardButton1);
        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardRow1);
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return sendMessage;
    }

    @Override
    public SendMessage katalogMenu(Update update) {
        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId()) //kimga yuboradi
                .setParseMode(ParseMode.MARKDOWN); //qanaqa format

        Optional<User> optionalUser = userRepository.findByChatId(update.getMessage().getChatId());

        User user = optionalUser.get();
        user.setState(BotState.KATALOG_MENU);
        userRepository.save(user);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup()
                .setOneTimeKeyboard(true)
                .setResizeKeyboard(true)
                .setSelective(true);
        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow(); //qator
        KeyboardRow keyboardRow1 = new KeyboardRow(); //qator
        KeyboardRow keyboardRow2 = new KeyboardRow(); //qator
        KeyboardRow keyboardRow3 = new KeyboardRow(); //qator

        KeyboardButton keyboardButton = new KeyboardButton(); //bitta button
        KeyboardButton keyboardButton1 = new KeyboardButton(); //bitta button
        KeyboardButton keyboardButton2 = new KeyboardButton(); //bitta button
        KeyboardButton keyboardButton3 = new KeyboardButton(); //bitta button
        KeyboardButton keyboardButton4 = new KeyboardButton(); //bitta button
        KeyboardButton keyboardButton5 = new KeyboardButton(); //bitta button
        KeyboardButton keyboardButton6 = new KeyboardButton(); //bitta button
        KeyboardButton keyboardButton7 = new KeyboardButton(); //bitta button

        keyboardButton.setText(Constant.CATEGORY);
        keyboardButton1.setText(Constant.MEASUREMENT);
        keyboardButton2.setText(Constant.CURRENCY);
        keyboardButton3.setText(Constant.SUPPLIER);
        keyboardButton4.setText(Constant.USERS);
        keyboardButton5.setText(Constant.WAREHOUSE);
        keyboardButton6.setText(Constant.PRODUCT);
        keyboardButton7.setText(Constant.BACK);


        keyboardRow.add(keyboardButton5); //ombor
        keyboardRow.add(keyboardButton); //category
        keyboardRow.add(keyboardButton1); //olchov birligi

        keyboardRow1.add(keyboardButton2);
        keyboardRow1.add(keyboardButton3);
        keyboardRow1.add(keyboardButton4);

        keyboardRow2.add(keyboardButton6);
        keyboardRow3.add(keyboardButton7);

        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardRow1);
        keyboardRows.add(keyboardRow2);
        keyboardRows.add(keyboardRow3);
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setText(Constant.KATALOG_MENU_TEXT);

        return sendMessage;
    }

    @Override
    public SendMessage warehouseSettings(Update update) {

        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId()) //kimga yuboradi
                .setParseMode(ParseMode.MARKDOWN); //qanaqa format

        Optional<User> optionalUser = userRepository.findByChatId(update.getMessage().getChatId());

        User user = optionalUser.get();
        user.setState(BotState.WAREHOUSE_MENU);
        userRepository.save(user);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup()
                .setOneTimeKeyboard(true)
                .setResizeKeyboard(true)
                .setSelective(true);
        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow(); //qator
        KeyboardRow keyboardRow1 = new KeyboardRow(); //qator
        KeyboardRow keyboardRow2 = new KeyboardRow(); //qator

        KeyboardButton keyboardButton = new KeyboardButton(); //bitta button
        KeyboardButton keyboardButton1 = new KeyboardButton(); //bitta button
        KeyboardButton keyboardButton2 = new KeyboardButton(); //bitta button
        KeyboardButton keyboardButton3 = new KeyboardButton(); //bitta button

        keyboardButton.setText(Constant.ADD);
        keyboardButton1.setText(Constant.EDIT);
        keyboardButton2.setText(Constant.DELETE);
        keyboardButton3.setText(Constant.BACK);


        keyboardRow.add(keyboardButton);
        keyboardRow1.add(keyboardButton1);
        keyboardRow1.add(keyboardButton2);

        keyboardRow2.add(keyboardButton3);

        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardRow1);
        keyboardRows.add(keyboardRow2);
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setText(Constant.KATALOG_MENU_TEXT);

        return sendMessage;

    }

    @Override
    public SendMessage warehouseAdd(Update update) {

        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId()) //kimga yuboradi
                .setParseMode(ParseMode.MARKDOWN); //qanaqa format

        String text = update.getMessage().getText();

        Optional<User> optionalUser = userRepository.findByChatId(update.getMessage().getChatId());
        User user = optionalUser.get();

        if (text.contains("=>")) {
            String[] split = text.split("=>");
            warehouse = wareHouseService.getById(Integer.parseInt(split[0]));
        }
        ReplyKeyboardRemove replyKeyboardMarkup = new ReplyKeyboardRemove();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setText(Constant.W_NAME);

        return sendMessage;
    }

    @Override
    public SendMessage warehouseAdd1(Update update) {

        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId()) //kimga yuboradi
                .setParseMode(ParseMode.MARKDOWN); //qanaqa format

        Optional<User> optionalUser = userRepository.findByChatId(update.getMessage().getChatId());

        User user = optionalUser.get();

        if (warehouse != null) {
            Warehouse edit = wareHouseService.edit(warehouse.getId(), warehouse);

            sendMessage.setText("Edit bo'ldi!");
            warehouse = null;

        } else {
            warehouse = new Warehouse();
            warehouse.setName(update.getMessage().getText());
            wareHouseService.add(warehouse);
            sendMessage.setText("Xullas qo'shildi!");
            warehouse = null;
        }


        ReplyKeyboardRemove replyKeyboardMarkup = new ReplyKeyboardRemove();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return sendMessage;
    }

    @Override
    public SendMessage warehouseEdit(Update update) {

        SendMessage sendMessage = new SendMessage()
                .setChatId(update.getMessage().getChatId()) //kimga yuboradi
                .setParseMode(ParseMode.MARKDOWN); //qanaqa format

        Optional<User> optionalUser = userRepository.findByChatId(update.getMessage().getChatId());

        User user = optionalUser.get();
        user.setState(BotState.WAREHOUSE_MENU);
        userRepository.save(user);

        List<Warehouse> all = wareHouseService.getAll();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup()
                .setOneTimeKeyboard(true)
                .setResizeKeyboard(true)
                .setSelective(true);
        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow backRow = new KeyboardRow();
        KeyboardButton backButton = new KeyboardButton();
        backButton.setText(Constant.BACK);
        keyboardRows.add(backRow);
        for (Warehouse warehouse : all) {
            KeyboardRow keyboardRow = new KeyboardRow(); //qator
            KeyboardButton keyboardButton = new KeyboardButton(); //bitta button

            keyboardButton.setText(warehouse.getId() + "=> " + warehouse.getName());

            keyboardRow.add(keyboardButton);
            keyboardRows.add(keyboardRow);
        }

        replyKeyboardMarkup.setKeyboard(keyboardRows);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setText(Constant.W_SELECT);

        return sendMessage;

    }

    @Override
    public SendMessage warehouseDelete(Update update) {
        return null;
    }

    @Override
    public SendMessage warehouseActive(Update update) {
        return null;
    }


}
