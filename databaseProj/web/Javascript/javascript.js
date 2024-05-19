
       function handleClick(column) {
            switch (column) {
                case 'firstColumn':
                    // Example navigation
                     window.location.href = '/databaseProj/formProjUpdate.jsp';
                    break;
                case 'secondColumn':
                    // Example navigation
                     window.location.href = '/databaseProj/error.jsp';
                    break;
                case 'thirdColumn':

                    // Example navigation
                     window.location.href = '/databaseProj/formProj.jsp';
                    break;
                default:
                    console.log("Unknown column");
            }
        }
        
        
