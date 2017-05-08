﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Household.Common;
using Household.Models.Bean;
using System.Web.Security;
using Household.Filters;
using log4net;

namespace Household.Controllers
{
    [Household.Filters.ActionFilter]
    public partial class HomeController : AbstractController
    {
        public ActionResult Index()
        {
            return View("~/Views/login.cshtml", "~/Views/master.cshtml");
        }

        public ActionResult Redirect()
        {
            return Redirect("/Home/ApplyConfirm");
        }

        public ActionResult ApplyConfirm()
        {
            return View("~/Views/applycorfirm.cshtml", "~/Views/master.cshtml");
        }

        public ActionResult Apply()
        {
            return Redirect("/Home/Main");
        }

        public ActionResult Main()
        {
            return View("~/Views/main.cshtml", "~/Views/master.cshtml");
        }
    }
}
