﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Net;
using System.IO;
using System.Text;

namespace Household.Common
{
    public class HttpConnector
    {
        private String serviceUrl = null;
        private String dataUrl = null;
        private static HttpConnector instance = null;
        public static HttpConnector CreateInstance(String serviceUrl, String dataUrl)
        {
            instance = new HttpConnector(serviceUrl, dataUrl);
            return instance;
        }
        public static HttpConnector GetInstance()
        {
            if(instance == null)
            {
                throw new NullReferenceException();
            }
            return instance;
        }
        public enum HttpMethod
        {
            POST,
            GET
        }
        public HttpConnector(String serviceUrl,String dataUrl)
        {
            this.serviceUrl = serviceUrl;
            this.dataUrl = dataUrl;
        }
        public string GetRequest(String url, HttpMethod method, IDictionary<String, string> param = null)
        {
            try
            {
                string paramStr = param != null ? combineParameter(param) : null;
                if (HttpMethod.GET.Equals(method) && paramStr != null)
                {
                    url += (url.IndexOf("?") != -1) ? "&" : "?" + paramStr;
                }
                HttpWebRequest request = (HttpWebRequest)WebRequest.Create(url);
                request.Method = method.ToString();
                request.ContentType = "application/x-www-form-urlencoded";
                if (HttpMethod.POST.Equals(method) && paramStr != null)
                {
                    byte[] byteArray = Encoding.UTF8.GetBytes(paramStr);
                    request.ContentLength = byteArray.Length;
                    using (Stream dataStream = request.GetRequestStream())
                    {
                        dataStream.Write(byteArray, 0, byteArray.Length);
                    }
                }
                using (HttpWebResponse response = (HttpWebResponse)request.GetResponse())
                {
                    using (StreamReader reader = new StreamReader(response.GetResponseStream()))
                    {
                        return reader.ReadToEnd();
                    }
                }
            }
            catch (Exception e)
            {
                return GetRequest(url, method, param);
            }
        }

        private string combineParameter(IDictionary<string, string> param)
        {
            StringBuilder sb = new StringBuilder();
            foreach (String key in param.Keys)
            {
                if (sb.Length > 0)
                {
                    sb.Append("&");
                }
                sb.Append(key).Append("=").Append(param[key]);
            }
            return sb.ToString();
        }

        public string GetDataRequest(String code, IDictionary<String, string> param = null)
        {
            String connUrl = serviceUrl + code;
            String key = GetRequest(connUrl, HttpMethod.POST, param);
            return GetRequest(dataUrl,
                              HttpMethod.POST,
                              new Dictionary<String, String>() { 
                              { "CODE", key } });
        }
    }
}