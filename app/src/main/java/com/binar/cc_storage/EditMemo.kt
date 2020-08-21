package com.binar.cc_storage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_edit_memo.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditMemo.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditMemo : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var db: MemoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_memo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.context?.let { it ->
            MemoDatabase.getInstance(it)?.let {
                db = it
            }
        }
        etEditDate.setText(memo.isDate)
        etEditMemo.setText(memo.isiMemo)


        tvCancel.setOnClickListener {
            dismiss()
        }

        tvDelete.setOnClickListener {
            GlobalScope.launch {
                val rowDeleted = db.memoDao().deleteItem(memo)

                activity?.runOnUiThread {
                    if (rowDeleted >0){
                        Snackbar.make(it, "Data Memo Terhapus", Snackbar.LENGTH_LONG).show()
                        dismiss()
                    } else {
                        Snackbar.make(it, "Data Memo Gagal Terhapus", Snackbar.LENGTH_LONG).show()
                    }
                    (activity as ProfileActivity).fetchData()
                }
            }
        }

        tvUpdate.setOnClickListener {
            memo.apply {
                isDate = etEditDate.text.toString()
                isiMemo = etEditMemo.text.toString()
            }

            GlobalScope.launch {
                val memoUpdated: Int = db.memoDao().updateItem(memo)

                activity?.runOnUiThread {
                    if (memoUpdated >0){
                        Snackbar.make(it, "Data Memo Terupdate", Snackbar.LENGTH_LONG).show()
                        dismiss()
                    } else {
                        Snackbar.make(it, "Data Memo Gagal Terupdate", Snackbar.LENGTH_LONG).show()
                    }
                    (activity as ProfileActivity).fetchData()
                }
            }
        }


    }

    companion object {
        lateinit var memo: Memo

        fun dataMemo(dataMemo: Memo): EditMemo {
            memo = dataMemo
            return EditMemo()
        }
    }
}