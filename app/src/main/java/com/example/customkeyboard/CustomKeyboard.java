package com.example.customkeyboard;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;

public class CustomKeyboard extends LinearLayout {

    private EditText targetEditText;

    public CustomKeyboard(Context context) {

        this(context, null, 0);
    }

    public CustomKeyboard(Context context, AttributeSet attrs) {

        this(context, attrs, 0);
    }

    public CustomKeyboard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.keyboard_layout, this, true);
        KeyboardView keyboardView = findViewById(R.id.keyboard_view);
        keyboardView.setKeyboard(new Keyboard(context, R.xml.custom_keyboard));
        keyboardView.setOnKeyboardActionListener(new KeyboardActionListener());
    }

    public void setTargetEditText(EditText editText) {

        targetEditText = editText;
    }

    private class KeyboardActionListener implements KeyboardView.OnKeyboardActionListener {

        @Override
        public void onPress(int primaryCode) {
            // Not used
        }

        @Override
        public void onRelease(int primaryCode) {
            // Not used
        }

        @Override
        public void onKey(int primaryCode, int[] keyCodes) {
            if (targetEditText == null) {
                return;
            }

            if (primaryCode == Keyboard.KEYCODE_DELETE) {
                // Handle delete key
                int cursorPos = targetEditText.getSelectionStart();
                if (cursorPos > 0) {
                    targetEditText.getText().delete(cursorPos - 1, cursorPos);
                }
            } else if (primaryCode == Keyboard.KEYCODE_DONE) {
                // Handle done key
                targetEditText.clearFocus();
            } else {
                // Handle alphabet key
                char letter = (char) primaryCode;
                targetEditText.getText().insert(targetEditText.getSelectionStart(), String.valueOf(letter));
            }
        }

        @Override
        public void onText(CharSequence text) {
            // Not used
        }

        @Override
        public void swipeLeft() {
            // Not used
        }

        @Override
        public void swipeRight() {
            // Not used
        }

        @Override
        public void swipeDown() {
            // Not used
        }

        @Override
        public void swipeUp() {
            // Not used
        }
    }
}
