package com.devpro.android55_day6;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devpro.android55_day6.interfaces.IOnProductClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IOnProductClickListener {

    private static final String TAG = "MainActivity";
    private ArrayList<ProductModel> mListData;
    private ProductAdapter mProductAdapter;
    private RecyclerView rvProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initView() {
        rvProduct = findViewById(R.id.rvProduct);
        mProductAdapter = new ProductAdapter(mListData, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setAdapter(mProductAdapter);

    }

    private void initData() {
        mListData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ProductModel productModel = new ProductModel();
            productModel.setProductName("Product "+i);
            productModel.setProductPrice(Double.valueOf(i));
            productModel.setProductSize("M");
            productModel.setProductColor("Red");
            productModel.setProductImage("https://vcdn1-dulich.vnecdn.net/2021/07/16/1-1626437591.jpg?w=460&h=0&q=100&dpr=2&fit=crop&s=i2M2IgCcw574LT-bXFY92g");
            mListData.add(productModel);
        }
    }

    @Override
    public void onProductClickListener(int position) {
        Log.d(TAG, "onProductClickListener: "+position);
    }

    @Override
    public void onAddProductToCart(int position) {
        Log.d(TAG, "onAddProductToCart: "+position);
    }

    @Override
    public void onRemoveProduct(int position) {
        Log.d(TAG, "onRemoveProduct: "+position);
        mListData.remove(position);
        mProductAdapter.notifyItemRemoved(position);
    }
}