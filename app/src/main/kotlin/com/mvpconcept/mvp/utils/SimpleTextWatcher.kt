package com.mvpconcept.mvp.utils

import android.text.Editable
import android.text.TextWatcher

class SimpleTextWatcher(val onTextChangeAction: (text: String) -> Unit): TextWatcher {
    override fun afterTextChanged(p0: Editable?) {

    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        onTextChangeAction.invoke(p0.toString())
    }
}