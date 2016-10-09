# EasyAdapter
简化更改ListView的展示模式，削弱Adapter的逻辑处理和View展示功能，极大的简化ListView加载数据的方式.

### 使用说明
  1. 所有的数据实现`IDataType`接口； 
    
  2. 对于每一种类型的数据需要一个`IViewHandler`的实现类，用于处理每种类型的数据，所有的View操作和数据的展示都从Adapter中脱离出来，放到`IViewHandler`中处理；
  3. 在`IDataType`中将对应的`ViewHandler`实现类的类名返回，用于后期的反射查找对应类；
  4. 在`IViewHandler`中将对应的资源ID返回；
  5. 在gradle中添加引用 compile 'com.silence.easyadapter:lib:1.0.0'
  
### 示例代码
  ```
    class Data implements IDataType{
        public String getViewHandlerName(){
            return SampleViewHandler.class.getName();    
        }
    }
    
    class SampleViewHandler implements IListViewHandler{
        public int getResId(){
            return layout资源ID;
        }
        
        public int getUniqueItemTypeId(){
          return 独一无二的数值（推荐直接用资源ID）
        }
        
        public void handleView(ViewHolder holder, int positon, T data, ViewGroup parent){
          //这里处理View的显示和数据的加载
        }
    }
    
    List<Data> dataList = //这里获取数据
    
    listview.setAdapter(new LEasyAdapter(dataList));
    
    搞定！！！
  
  ```
  

![](https://github.com/wangsai-silence/EasyAdapter/blob/master/Class%20Diagram.png)
